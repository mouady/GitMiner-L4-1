package aiss.gitminer.controller;

import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gitminer")
public class ProjectsController {

    @Autowired
    ProjectRepository projectRepository;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping("/projects")
    public Project create(@Valid @RequestBody Project project) {
        return projectRepository.save(new Project(project.getId(),project.getName(),
                project.getWebUrl(),project.getCommits(),project.getIssues()));
    }

}
