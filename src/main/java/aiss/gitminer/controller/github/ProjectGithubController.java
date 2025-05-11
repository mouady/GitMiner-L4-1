package aiss.gitminer.controller.github;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.gitminer.repository.CommentRepository;
import aiss.gitminer.repository.CommitRepository;
import aiss.gitminer.repository.IssueRepository;
import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.services.github.CommitGithubService;
import aiss.gitminer.services.github.IssueGithubService;
import aiss.gitminer.services.github.RepositoryGithubService;
import aiss.gitminer.transformers.github.CommitGithubTransformer;
import aiss.gitminer.transformers.github.IssueGithubTransformer;
import aiss.gitminer.transformers.github.RepositoryGithubTransformer;
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

@Tag(name= "ProjectsGithub", description="Projects extracted from GitHub")
@RestController
@RequestMapping("/github")
public class ProjectGithubController {

    @Autowired
    ProjectRepository projectRepository;

    // Services
    @Autowired
    RepositoryGithubService repositoryGithubService;

    @Autowired
    CommitGithubService commitGithubService;

    @Autowired
    IssueGithubService issueGithubService;

    private Project getProjectObject(String owner, String repo,
                                     Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        Project res = RepositoryGithubTransformer.transformToProject(repositoryGithubService.getRepository(owner, repo));
        List<Commit> commits = CommitGithubTransformer.transformToCommits(
                        commitGithubService.getAllCommits(owner, repo, sinceCommits, maxPages));
        res.setCommits(commits);

        List<Issue> issues = IssueGithubTransformer.transformToIssues(
                        issueGithubService.getAllIssuesFromRepo(owner, repo, sinceIssues, maxPages), maxPages);
        res.setIssues(issues);

        return res;
    }

    @Operation(
            summary = "Retrieve Project",
            description = "Get Project from a repository",
            tags = {"ProjectsGithub","GET"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Project.class)
                    ,mediaType = "application/json")})
    })
    @GetMapping("/{owner}/{repo}")
    public Project getProject(@PathVariable String owner, @PathVariable String repo,
                              @RequestParam(required = false) Integer sinceCommits,
                              @RequestParam(required = false) Integer sinceIssues,
                              @RequestParam(required = false) Integer maxPages) {

        return getProjectObject(owner, repo, sinceCommits, sinceIssues, maxPages);
    }

    @Operation(
            summary= "Insert a Project",
            description = "From GitHub it extract a project and insert it in GitMiner",
            tags = { "ProjectsGithub","POST"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",content = {@Content(schema=@Schema(implementation = Project.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",content = {@Content(schema = @Schema()) })
    })
    @PostMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@PathVariable String owner, @PathVariable String repo,
                              @RequestParam(required = false) Integer sinceCommits,
                              @RequestParam(required = false) Integer sinceIssues,
                              @RequestParam(required = false) Integer maxPages) {

        Project res = getProjectObject(owner, repo, sinceCommits, sinceIssues, maxPages);

        return projectRepository.save(res);
    }
}
