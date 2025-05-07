package aiss.gitminer.controller;

import aiss.gitminer.exception.ProjectNotFoundException;
import aiss.gitminer.model.Issue;
import aiss.gitminer.repository.ProjectRepository;
import aiss.gitminer.model.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("/projects")
    public List<Project> getAllProjects(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(required = false) String order,
                                        @RequestParam(defaultValue = "3") int size) {
        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else
            paging = PageRequest.of(page, size);

        Page<Project> pageProjects;
        pageProjects = projectRepository.findAll(paging);
        return pageProjects.getContent();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/projects")
    public void create(@Parameter(description = "Project to be inserted") @Valid @RequestBody Project project) {
        projectRepository.save(new Project(project.getId(), project.getName(),
                project.getWebUrl(), project.getCommits(), project.getIssues()));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            projectRepository.deleteById(id.trim());
            return ResponseEntity.noContent().build();
        }catch(EmptyResultDataAccessException ex) {
            return ResponseEntity.notFound().build();
        }}

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
    public void update(@Parameter(description = "Id of the project to be updated and the updates" )
                       @PathVariable String id,@Valid @RequestBody Project updatedProject)
            throws ProjectNotFoundException {
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