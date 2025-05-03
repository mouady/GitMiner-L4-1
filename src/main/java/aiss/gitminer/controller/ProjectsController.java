package aiss.gitminer.controller;

import aiss.gitminer.exception.ProjectNotFoundException;
import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.model.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name= "Project", description="Project extracted from Git")
@RestController
@RequestMapping("/gitminer")
public class ProjectsController {

    @Autowired
    ProjectRepository projectRepository;

    @Operation(
            summary= "Insert a Project",
            description = "From git it extract a project and insert it in GitMiner",
            tags = { "projects","post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",content = {@Content(schema=@Schema(implementation = Project.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",content = {@Content(schema = @Schema()) })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/projects")
    public Project create(@Valid @RequestBody Project project) {
        return projectRepository.save(new Project(project.getId(),project.getName(),
                project.getWebUrl(),project.getCommits(),project.getIssues()));
    }

    @Operation(
            summary= "update a Project",
            description = "Update a Project by specifying its id and whose data is passed",
            tags = { "projects","put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204",content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400",content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404",content = {@Content(schema = @Schema()) })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("projects/{id}")
    public void update(@Valid @RequestBody Project updatedProject, @PathVariable String id) throws ProjectNotFoundException {
        Optional<Project> projectData=projectRepository.findById(id);

        if(projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setName(updatedProject.getName());
            _project.setWebUrl((updatedProject.getWebUrl()));
            _project.setCommits(updatedProject.getCommits());
            _project.setIssues(updatedProject.getIssues());
            projectRepository.save(_project);
        }else{
            throw new ProjectNotFoundException();
        }
    }

}
