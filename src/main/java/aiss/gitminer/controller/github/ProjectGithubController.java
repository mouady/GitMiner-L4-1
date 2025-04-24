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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
