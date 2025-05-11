package aiss.gitminer.controller.bitbucket;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.gitminer.model.bitbucket.IssueBitbucket;
import aiss.gitminer.model.bitbucket.RepositoryBitbucket;
import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.services.bitbucket.CommentBitbucketService;
import aiss.gitminer.services.bitbucket.CommitBitbucketService;
import aiss.gitminer.services.bitbucket.IssueBitbucketService;
import aiss.gitminer.services.bitbucket.RepositoryBitbucketService;
import aiss.gitminer.transformers.bitbucket.CommentBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.CommitBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.IssueBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.RepositoryBitbucketTransformer;
import aiss.gitminer.util.Environment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name= "ProjectsBitbucket", description="Projects extracted from Bitbucket")
@RestController
@RequestMapping("/bitbucket")
public class ProjectBitbucketController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RepositoryBitbucketService repositoryBitbucketService;

    @Autowired
    private CommitBitbucketService commitBitbucketService;

    @Autowired
    private IssueBitbucketService issueBitbucketService;

    @Autowired
    private CommentBitbucketService commentBitbucketService;

    /**
     * Construye el objeto Project usando los servicios de Bitbucket.
     *
     * @param owner     propietario del repositorio
     * @param repo      nombre del repositorio
     * @param nCommits  commits por página
     * @param nIssues   issues por página
     * @param maxPages  número máximo de páginas a recorrer
     */
    private Project getProjectObject(String owner, String repo,
                                     int nCommits, int nIssues, int maxPages) {
        RepositoryBitbucket repoBB = repositoryBitbucketService.getRepository(owner, repo);
        Project project = RepositoryBitbucketTransformer.transformToProject(repoBB);

        List<Commit> commits = CommitBitbucketTransformer
                .transformToCommits(
                        commitBitbucketService.getAllCommits(owner, repo, nCommits, maxPages)
                );
        project.setCommits(commits);

        List<IssueBitbucket> rawIssues = issueBitbucketService.getAllIssuesFromRepo(owner, repo, nIssues, maxPages);
        List<Issue> issues = new ArrayList<>();
        for (IssueBitbucket bbIssue : rawIssues) {
            Issue issue = IssueBitbucketTransformer.transform(bbIssue);

            String commentsUrl = Environment.BITBUCKET_BASEURI
                    + owner + "/" + repo
                    + "/issues/" + issue.getId()
                    + "/comments";

            List<Comment> comments = CommentBitbucketTransformer
                    .transformListOfCommentValuesToComments(
                            commentBitbucketService.getAllCommentsFromIssue(commentsUrl, null)
                    );
            issue.setComments(comments);
            issues.add(issue);
        }
        project.setIssues(issues);

        return project;
    }

    @Operation(
            summary = "Retrieve Project",
            description = "Get Project from a repository",
            tags = {"ProjectsBitbucket","GET"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Project.class)
                    ,mediaType = "application/json")})
    })
    @GetMapping("/{owner}/{repo}")
    public Project getProject(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestParam(defaultValue = "5") int nCommits,
            @RequestParam(defaultValue = "5") int nIssues,
            @RequestParam(defaultValue = "2") int maxPages) {

        return getProjectObject(owner, repo, nCommits, nIssues, maxPages);
    }

    @Operation(
            summary= "Insert a Project",
            description = "From GitHub it extract a project and insert it in GitMiner",
            tags = { "ProjectsBitbucket","POST"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",content = {@Content(schema=@Schema(implementation = Project.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",content = {@Content(schema = @Schema()) })
    })
    @PostMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestParam(defaultValue = "5") int nCommits,
            @RequestParam(defaultValue = "5") int nIssues,
            @RequestParam(defaultValue = "2") int maxPages) {

        Project project = getProjectObject(owner, repo, nCommits, nIssues, maxPages);
        return projectRepository.save(project);
    }
}