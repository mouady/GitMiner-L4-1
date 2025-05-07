package aiss.gitminer.controllers;

import aiss.gitminer.controller.ProjectsController;
import aiss.gitminer.exception.ProjectNotFoundException;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.gitminer.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest

class ProjectsControllerTest {

    @Autowired
    ProjectsController controller;

    @Test
    void create() {
        String id ="15717393";
        String name="pitest";
        String webUrl="https://github.com/hcoles/pitest";

        Commit commit1 = new Commit("ee6e291274fcca03801261f1fd0684aa32c6d140",
                "Merge pull request #1150 from hcoles/feature/results_interceptors",
                "\n\nNew extension point",
                "Henry Coles",
                "henry.coles@googlemail.com",
                "2023-01-25T13:06:19Z",
                "https://github.com/hcoles/pitest/commit/ee6e291274fcca03801261f1fd0684aa32c6d140");
        Commit commit2=new Commit("95e8102725b59780c07e89d4fca9a7563f12c976",
                "New extension points",
                "Adds new extension points to allow post analysis modification of coverage " +
                        "and mutation analysis results. Extensions points have multiple potential uses, but " +
                        "first use case is supporting the 'un-inlining' of inlined kotlin functions. Change " +
                        "requires alteration of existing interfaces which may be incompatible with some third party " +
                        "plugins",
                "Henry Coles",
                "henry@pitest.org",
                "2023-01-12T09:29:33Z",
                "https://github.com/hcoles/pitest/commit/95e8102725b59780c07e89d4fca9a7563f12c976");

        Issue issue1 = new Issue("1556497126",
                "New extension points",
                "Adds new extension points to allow post analysis modification of coverage and mutation analysis " +
                   "results. Extensions points have multiple potential uses, but first use case is " +
                   "supporting the 'un-inlining' of inlined kotlin functions. Change requires alteration " +
                   "of existing interfaces which may be incompatible with some third party plugins.",
                "closed",
                "2023-01-25T11:35:30Z",
                "2023-01-25T13:06:20Z",
                "2023-01-25T13:06:19Z",
                new ArrayList<>(),
                new User("1891135",
                    "hcoles",
                    "Henry Coles",
                    "https://avatars.githubusercontent.com/u/1891135?v=4",
                    "https://api.github.com/users/hcoles"),
                null,
                0,
                new ArrayList<>());

        Project createdProject = new Project(id,name,webUrl,List.of(commit1,commit2),List.of(issue1));
        controller.create(createdProject);
    }

    @Test
    void update() throws ProjectNotFoundException {
        String id ="15717393";
        String name="updated";
        String webUrl="https://github.com/hcoles/updated";

        Commit commit1 = new Commit("ee6e291274fcca03801261f1fd0684aa32c6d140",
                "Merge pull request #1150 from hcoles/feature/results_interceptors",
                "New extension point",
                "Henry Coles",
                "henry.coles@googlemail.com",
                "2023-01-25T13:06:19Z",
                "https://github.com/hcoles/updated/commit/ee6e291274fcca03801261f1fd0684aa32c6d140");
        Commit commit2=new Commit("95e8102725b59780c07e89d4fca9a7563f12c976",
                "New extension points",
                "Adds new extension points to allow post analysis modification of coverage " +
                        "and mutation analysis results. Extensions points have multiple potential uses, but " +
                        "first use case is supporting the 'un-inlining' of inlined kotlin functions. Change " +
                        "requires alteration of existing interfaces which may be incompatible with some third party " +
                        "plugins",
                "Henry Coles",
                "henry@updated.org",
                "2023-01-12T09:29:33Z",
                "https://github.com/hcoles/updated/commit/95e8102725b59780c07e89d4fca9a7563f12c976");

        Issue issue1 = new Issue("1556497126",
                "New extension points",
                "Adds new extension points to allow post analysis modification of coverage and mutation analysis " +
                        "results. Extensions points have multiple potential uses, but first use case is " +
                        "supporting the 'un-inlining' of inlined kotlin functions. Change requires alteration " +
                        "of existing interfaces which may be incompatible with some third party plugins.",
                "closed",
                "2023-01-25T11:35:30Z",
                "2023-01-25T13:06:20Z",
                "2023-01-25T13:06:19Z",
                new ArrayList<>(),
                new User("1891135",
                        "hcoles",
                        "Henry Coles",
                        "https://avatars.githubusercontent.com/u/1891135?v=4",
                        "https://api.github.com/users/hcoles"),
                null,
                0,
                new ArrayList<>());

        Project updatedProject = new Project(id,name,webUrl,List.of(commit1,commit2),List.of(issue1));
        controller.update(id,updatedProject);

    }
}