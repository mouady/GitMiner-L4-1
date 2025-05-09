package aiss.gitminer.controllers;

import aiss.gitminer.controller.CommitsController;
import aiss.gitminer.model.Commit;
import aiss.gitminer.exception.CommitNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class CommitsControllerTest {

    @Autowired
    CommitsController controller;

    @Test
    void getCommit() throws CommitNotFoundException {
        Commit commit = controller.getCommit("ee6e291274fcca03801261f1fd0684aa32c6d140");
            System.out.println("==================================");
            System.out.println("ID: " + commit.getId());
            System.out.println("Title: " + commit.getTitle());
            System.out.println("Message: " + commit.getMessage());
            System.out.println("AuthorName: " + commit.getAuthorName());
            System.out.println("AuthorEmail: " + commit.getAuthorEmail());
            System.out.println("AuthoredDate: " + commit.getAuthoredDate());
            System.out.println("WebUrl: " + commit.getWebUrl());
    }
    @Test
    void getAllCommits() throws CommitNotFoundException {
        List<Commit> commits = controller.getAllCommits();
        for (Commit commit : commits) {
            System.out.println("==================================");
            System.out.println("ID: " + commit.getId());
            System.out.println("Title: " + commit.getTitle());
            System.out.println("Message: " + commit.getMessage());
            System.out.println("AuthorName: " + commit.getAuthorName());
            System.out.println("AuthorEmail: " + commit.getAuthorEmail());
            System.out.println("AuthoredDate: " + commit.getAuthoredDate());
            System.out.println("WebUrl: " + commit.getWebUrl());
        }
    }

    @Test
    void getCommitByEmail() throws CommitNotFoundException {
        List<Commit> commits = controller.getCommitsByEmail("a@gmail.com");
        for (Commit commit : commits) {
            System.out.println("==================================");
            System.out.println("ID: " + commit.getId());
            System.out.println("Title: " + commit.getTitle());
            System.out.println("Message: " + commit.getMessage());
            System.out.println("AuthorName: " + commit.getAuthorName());
            System.out.println("AuthorEmail: " + commit.getAuthorEmail());
            System.out.println("AuthoredDate: " + commit.getAuthoredDate());
            System.out.println("WebUrl: " + commit.getWebUrl());
        }
    }
}