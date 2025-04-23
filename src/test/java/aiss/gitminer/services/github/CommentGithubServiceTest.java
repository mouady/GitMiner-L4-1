package aiss.gitminer.services.github;

import aiss.gitminer.model.github.CommentGithub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class CommentGithubServiceTest {

    @Autowired
    CommentGithubService service;

    @Test
    void getAllCommentsFromIssue() {
        List<CommentGithub> comments = service.getAllCommentsFromIssue("https://api.github.com/repos/spring-projects/spring-framework/issues/34765/comments", null);
        // actualmente son 6 los comentarios de esta issue cerrada
        assert(comments.size() == 6);
        for (CommentGithub comment : comments) {
            System.out.println("==================================");
            System.out.println("Id: " + comment.getId());
            System.out.println("Body: " + comment.getBody());
            System.out.println("Created_at: " + comment.getCreated_at());
            System.out.println("Updated_at: " + comment.getUpdated_at());
            System.out.println("==================================");
        }
    }
}