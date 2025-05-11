package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.bitbucket.commit.CommitBitbucket;
import aiss.gitminer.transformers.bitbucket.CommitBitbucketTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommitBitbucketServiceTest {

    @Autowired
    CommitBitbucketService service;

    @Test
    void getAllCommits() {

        List<CommitBitbucket> commitsBitbucket = service.getAllCommits("gentlero","bitbucket-api", null, 20);
        for (CommitBitbucket commitBitbucket : commitsBitbucket) {

            // Notese que usamos el transformer
            Commit commit = CommitBitbucketTransformer.transformToCommit(commitBitbucket);

            System.out.println("==================================");
            System.out.println("ID: " + commit.getId());
            System.out.println("Title: " + commit.getTitle());
            System.out.println("Message: " + commit.getMessage());
            System.out.println("Author Name: " + commit.getAuthorName());
            System.out.println("Author Email: " + commit.getAuthorEmail());
            System.out.println("Authored Date: " + commit.getAuthoredDate());
            System.out.println("Web URL: " + commit.getWebUrl());
            System.out.println("==================================");
        }


    }
}