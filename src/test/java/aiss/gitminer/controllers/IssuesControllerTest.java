package aiss.gitminer.controllers;

import aiss.gitminer.controller.IssuesController;
import aiss.gitminer.exception.IssueNotFoundException;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IssuesControllerTest {

    @Autowired
    IssuesController controller;

    @Test
    void getIssue() throws IssueNotFoundException {

        Issue issue = controller.getIssue("1556497126");
            System.out.println("==================================");
            System.out.println("ID: " + issue.getId());
            System.out.println("Title: " + issue.getTitle());
            System.out.println("Description: " + issue.getDescription());
            System.out.println("State: " + issue.getState());
            System.out.println("Author: " + issue.getAuthor());
            System.out.println("Created At: " + issue.getCreatedAt());
            System.out.println("Updated At: " + issue.getUpdatedAt());
            System.out.println("Closed At: " + issue.getClosedAt());
            System.out.println("Labels: " + issue.getLabels());
            System.out.println("Assignee: " + issue.getAssignee());
            System.out.println("Votes: " + issue.getVotes());
            System.out.println("==================================");

    }

        @Test
        void getIssueComments () throws IssueNotFoundException {
            List<Comment> comments = controller.getIssueComments("1556497126");
                for( Comment comment : comments){
                    System.out.println("==================================");
                    System.out.println("ID: " + comment.getId());
                    System.out.println("Body: " + comment.getBody());
                    System.out.println("Author: " + comment.getAuthor());
                    System.out.println("CreatedAt: " + comment.getCreatedAt());
                    System.out.println("UpdatedAt: " + comment.getUpdatedAt());
                    System.out.println("==================================");
                }

        }

}