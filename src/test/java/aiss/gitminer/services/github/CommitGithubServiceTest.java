package aiss.gitminer.services.github;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.github.CommitGithub;
import aiss.gitminer.transformers.github.CommitGithubTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommitGithubServiceTest {

    @Autowired
    CommitGithubService service;

    @Test
    void getAllCommits() {

        List<CommitGithub> commitsGithub = service.getAllCommits("spring-projects","spring-framework", null, null);
        for (CommitGithub commitGithub : commitsGithub) {

            // Notese que usamos el transformer
            Commit commit = CommitGithubTransformer.transformToCommit(commitGithub);

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