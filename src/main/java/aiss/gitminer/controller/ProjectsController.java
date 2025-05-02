package aiss.gitminer.controller;

import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/gitminer")
public class ProjectsController {

    @Autowired
    ProjectRepository projectRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/projects")
    public Project create(@Valid @RequestBody Project project) {
        return projectRepository.save(new Project(project.getId(),project.getName(),
                project.getWebUrl(),project.getCommits(),project.getIssues()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("projects/{id}")
    public void update(@Valid @RequestBody Project updatedProject, @PathVariable String id) {
        Optional<Project> projectData=projectRepository.findById(id);

        Project _project = projectData.get();
        _project.setName(updatedProject.getName());
        _project.setWebUrl((updatedProject.getWebUrl()));
        _project.setCommits(updatedProject.getCommits());
        _project.setIssues(updatedProject.getIssues());
        projectRepository.save(_project);
    }
;

}
