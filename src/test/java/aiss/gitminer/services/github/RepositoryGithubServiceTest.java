package aiss.gitminer.services.github;

import aiss.gitminer.model.github.RepositoryGithub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryGithubServiceTest {

    @Autowired
    RepositoryGithubService service;

    @Test
    void getRepository() {
        String owner = "spring-projects";
        String repo = "spring-framework";
        RepositoryGithub repositoryGithub = service.getRepository(owner, repo);
        assertEquals(1148753, repositoryGithub.getId());
        assertEquals("https://github.com/spring-projects/spring-framework", repositoryGithub.getHtmlUrl());
        System.out.println("==================================");
        System.out.println("ID: " + repositoryGithub.getId());
        System.out.println("Name: " + repositoryGithub.getName());
        System.out.println("HTML URL: " + repositoryGithub.getHtmlUrl());
        System.out.println("==================================");


    }
}