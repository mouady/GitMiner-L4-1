package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.comments.CommentValueBitbucket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentBitbucketServiceTest {
    @Autowired
    CommentBitbucketService service;

    @Test
    void getAllCommentsFromIssue() {
        List<CommentValueBitbucket> comments = service.getAllCommentsFromIssue("https://api.bitbucket.org/2.0/repositories/gentlero/bitbucket-api/issues/87/comments", null);
        // actualmente son 6 los comentarios de esta issue cerrada
        for (CommentValueBitbucket comment : comments) {
            System.out.println("==================================");
            System.out.println("Id: " + comment.getId());
            System.out.println("Body: " + comment.getContent().getRaw());
            System.out.println("Created_at: " + comment.getCreatedOn());
            System.out.println("Updated_at: " + comment.getUpdatedOn());
            System.out.println("==================================");
        }
    }
}
