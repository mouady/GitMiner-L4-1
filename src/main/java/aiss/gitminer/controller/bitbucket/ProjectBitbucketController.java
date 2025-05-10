package aiss.gitminer.controller.bitbucket;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import aiss.gitminer.model.bitbucket.esclave.RepositoryBitbucket;
import aiss.gitminer.repository.CommentRepository;
import aiss.gitminer.repository.CommitRepository;
import aiss.gitminer.repository.IssueRepository;
import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.services.bitbucket.CommitBitbucketService;
import aiss.gitminer.services.bitbucket.IssueBitbucketService;
import aiss.gitminer.services.bitbucket.RepositoryBitbucketService;
import aiss.gitminer.transformers.bitbucket.CommitBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.IssueBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.RepositoryBitbucketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bitbucket")
public class ProjectBitbucketController {

    @Autowired
    ProjectRepository projectRepository;

    // Services
    @Autowired
    RepositoryBitbucketService repositoryBitbucketService;

    @Autowired
    CommitBitbucketService commitBitbucketService;

    @Autowired
    IssueBitbucketService issueBitbucketService;

    private Project getProjectObject(String owner, String repo,
                                     Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        Project res = RepositoryBitbucketTransformer.transformToProject(repositoryBitbucketService.getRepository(owner, repo));
        List<Commit> commits = CommitBitbucketTransformer.transformToCommits(
                commitBitbucketService.getAllCommits(owner, repo, sinceCommits, maxPages));
        res.setCommits(commits);


        List<IssueBitbucket> oi = issueBitbucketService.getAllIssuesFromRepo(owner, repo, maxPages);
        List<Issue> issues = new ArrayList<>();
        for (IssueBitbucket cissue : oi) {
            Issue cache = IssueBitbucketTransformer.transform(cissue);
            issues.add(cache);
        }
        res.setIssues(issues);

        return res;
    }

    @GetMapping("/{owner}/{repo}")
    public Project getProject(@PathVariable String owner, @PathVariable String repo,
                              @RequestParam(required = false) Integer sinceCommits,
                              @RequestParam(required = false) Integer sinceIssues,
                              @RequestParam(required = false) Integer maxPages) {

        return getProjectObject(owner, repo, sinceCommits, sinceIssues, maxPages);
    }

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
