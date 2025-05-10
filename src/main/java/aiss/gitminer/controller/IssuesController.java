package aiss.gitminer.controller;

import aiss.gitminer.exception.IssueNotFoundException;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.IssueRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Issues",description="Issues extracted from a Project")
@RestController
@RequestMapping("/gitminer")
public class IssuesController {

    @Autowired
    IssueRepository issueRepository;

//GET
    @Operation(
            summary = "Retrieve an Issue by Id",
            description = "Get an Issue object by specifying its id",
            tags = {"Issues","GET"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",content = {@Content(schema = @Schema()) })
    })
    @GetMapping("/issues/{id}")
    public Issue getIssue(@Parameter(description = "id of the issue to be searched")
                          @PathVariable String id) throws IssueNotFoundException {
        Optional<Issue> issue = issueRepository.findById(id);
        if (issue.isPresent()) {
            return issue.get();
        }
        throw new IssueNotFoundException();
    }

//GET ALL & FIND BY STATE AND TITLE
    @Operation(
            summary = "Retrieve a list of issues",
            description = "Get the list of issues and you can filter by title, state and authorId",
            tags = {"Issues","GET"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")})
    })
    @GetMapping("/issues")
    public List<Issue> getAllIssues(@RequestParam(required = false) String title,
                                    @RequestParam(required = false) String order,
                                    @RequestParam(required = false) String state,
                                    @RequestParam(required = false) String authorId,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "50") int size) throws IssueNotFoundException {
        Pageable paging;

        if(order != null) {
            if(order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging= PageRequest.of(page,size,Sort.by(order).ascending());
        }else
            paging=PageRequest.of(page,size);

        Page<Issue> pageProjects;

        if(title == null && state == null && authorId == null) {
            pageProjects = issueRepository.findAll(paging);
        } else {
            if(title == null && authorId == null)
                pageProjects = issueRepository.findByState(state, paging);
            else if(state == null && authorId == null)
                pageProjects = issueRepository.findByTitle(title, paging);
            else if(authorId != null)
                pageProjects = issueRepository.findByAuthorId(authorId, paging);
            else
                throw new IssueNotFoundException("No se han encontrado ninguna Issue con los criterios dados.");
        }

        if (authorId != null && pageProjects.isEmpty()) {
            throw new IssueNotFoundException("No se han encontrado ninguna Issue para --> " + authorId);
        }

        return pageProjects.getContent();

    }

//GET Issue's Comments
    @Operation(
            summary = "Retrieve an Issue comments",
            description = "Get all Issue's comments by specifying its id",
            tags = {"Issues","GET"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",content = {@Content(schema = @Schema()) })
    })
    @GetMapping("issues/{id}/comments")
    public List<Comment> getIssueComments(@Parameter(description = "id of the issue whose commits we search")
                                          @PathVariable String id) throws IssueNotFoundException {
        return getIssue(id).getComments(); }

}