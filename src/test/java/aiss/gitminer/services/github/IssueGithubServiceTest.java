package aiss.gitminer.services.github;

import aiss.gitminer.model.github.IssueGithub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IssueGithubServiceTest {

    @Autowired
    IssueGithubService service;

    @Test
    void getAllIssues() {
        List<IssueGithub> issues = service.getAllIssuesFromRepo("spring-projects", "spring-framework", null, null);
        for (IssueGithub issue : issues) {
            System.out.println("==================================");
            System.out.println("ID: " + issue.getId());
            System.out.println("Title: " + issue.getTitle());
            System.out.println("Body: " + issue.getBody());
            System.out.println("State: " + issue.getState());
            System.out.println("Created At: " + issue.getCreatedAt());
            System.out.println("Updated At: " + issue.getUpdatedAt());
            System.out.println("Closed At: " + issue.getClosedAt());
            System.out.println("Labels: " + issue.getLabels());
            System.out.println("User: " + issue.getUser());
            System.out.println("Assignee: " + issue.getAssignee());
            System.out.println("==================================");
        }

    }
}