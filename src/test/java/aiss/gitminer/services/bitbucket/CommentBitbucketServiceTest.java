package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.comments.CommentBitbucket;
import aiss.gitminer.model.bitbucket.esclave.comments.CommentValue;
import aiss.gitminer.model.github.CommentGithub;
import aiss.gitminer.services.bitbucket.CommentBitbucketService;
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
        List<CommentValue> comments = service.getAllCommentsFromIssue("https://api.bitbucket.org/2.0/repositories/gentlero/bitbucket-api/issues/87/comments", null);
        // actualmente son 6 los comentarios de esta issue cerrada
        for (CommentValue comment : comments) {
            System.out.println("==================================");
            System.out.println("Id: " + comment.getId());
            System.out.println("Body: " + comment.getContent().getRaw());
            System.out.println("Created_at: " + comment.getCreatedOn());
            System.out.println("Updated_at: " + comment.getUpdatedOn());
            System.out.println("==================================");
        }
    }
}
