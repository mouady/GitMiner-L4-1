package aiss.gitminer.controller.bitbucket;

import aiss.gitminer.model.Project;
import aiss.gitminer.repository.ProjectRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitbucket")

public class ProjectBitbucketController {
    @Autowired
    ProjectRepository projectRepository;

    @Operation(
            summary="Insert a Project",
            description="From git it extracts a project and inserts it in GitMiner",
            tags={"projects", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema=@Schema(implementation = Project.class),
                mediaType="application/json")}),
            @ApiResponse(responseCode="400", content={@Content(schema = @Schema())})
    })

    @GetMapping("/projects")
    public List<Project> getAllProjects(@RequestParam(defaultValue="0") int page,
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

    @GetMapping("/projects/{id}/commits")

    public ResponseEntity<Void> get(@PathVariable String id) {
        try {
            projectRepository.findById(id.trim());
            return ResponseEntity.noContent().build();
        }catch(EmptyResultDataAccessException ex) {
            return ResponseEntity.notFound().build();
        }}
}
