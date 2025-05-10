package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IssueBitbucketServiceTest {
    @Autowired
    IssueBitbucketService service;

    @Test
    void getAllIssues() {
        List<IssueBitbucket> issues = service.getAllIssuesFromRepo("gentlero", "bitbucket-api", null, null);
        for (IssueBitbucket issue : issues) {
            System.out.println("==================================");
            System.out.println("ID: " + issue.getId());
            System.out.println("Title: " + issue.getTitle());
            System.out.println("Body: " + issue.getContent().getRaw());
            System.out.println("State: " + issue.getState());
            System.out.println("Created At: " + issue.getCreatedOn());
            System.out.println("Updated At: " + issue.getUpdatedOn());
            // System.out.println("Labels: " + issue.getLabels());
            System.out.println("User: " + issue.getReporter());
            System.out.println("Assignee: " + issue.getAssignee());
            System.out.println("==================================");
        }

    }
}
