package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.RepositoryBitbucket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RepositoryBitbucketServiceTest {

    @Autowired
    RepositoryBitbucketService service;

    @Test
    void getRepository() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        RepositoryBitbucket repositoryBitbucket = service.getRepository(owner, repo);
        System.out.println("==================================");
        System.out.println("ID: " + repositoryBitbucket.getUuid());
        System.out.println("Name: " + repositoryBitbucket.getName());
        System.out.println("HTML URL: " + repositoryBitbucket.getWebsite());
        System.out.println("==================================");


    }
}