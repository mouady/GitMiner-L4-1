package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.github.CommentGithub;
import aiss.gitminer.model.github.IssueGithub;
import aiss.gitminer.model.github.LabelGithub;
import aiss.gitminer.services.github.CommentGithubService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class IssueGithubTransformer {

    private static final CommentGithubService commentGithubService = new CommentGithubService();

    private static List<Comment> getCommentsFromIssue(IssueGithub issueGithub, Integer maxPages) {
        List<Comment> res = new ArrayList<>();

        if(issueGithub.getComments() != 0) {
            List<CommentGithub> commentsGithub = commentGithubService.getAllCommentsFromIssue(
                    issueGithub.getCommentsUrl(), maxPages);
            res = CommentGithubTransformer.transformToComments(commentsGithub);
        }

        return res;
    }

    public static Issue transformToIssue(IssueGithub issueGithub, Integer maxPages) {
        return new Issue(issueGithub.getId(),
                "",
                issueGithub.getTitle(),
                issueGithub.getBody(),
                issueGithub.getState(),
                issueGithub.getCreatedAt(),
                issueGithub.getUpdatedAt(),
                issueGithub.getClosedAt(),
                issueGithub.getLabels().stream().map(LabelGithub::getName).toList(),
                UserGithubTransformer.transformToUser(issueGithub.getUser()),
                UserGithubTransformer.transformToUser(issueGithub.getAssignee()),
                null,
                null,
                issueGithub.getUrl(),
                getCommentsFromIssue(issueGithub, maxPages));
    }

    public static List<Issue> transformToIssues(List<IssueGithub> issues, Integer maxPages) {
        return issues.stream()
                .map(i -> transformToIssue(i, maxPages))
                .toList();
    }
}
