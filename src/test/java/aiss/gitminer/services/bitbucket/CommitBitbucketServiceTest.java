package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.bitbucket.esclave.CommitBitbucket;
import aiss.gitminer.model.github.CommitGithub;
import aiss.gitminer.services.github.CommitGithubService;
import aiss.gitminer.transformers.bitbucket.CommitBitbucketTransformer;
import aiss.gitminer.transformers.github.CommitGithubTransformer;
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

        List<CommitBitbucket> commitsBitbucket = service.getAllCommits("gentlero","bitbucket-api", null, null);
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