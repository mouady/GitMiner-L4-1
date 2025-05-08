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

@Tag(name= "Issue",description="Issue extracted from a Project")
@RestController
@RequestMapping("/gitminer")
public class IssuesController {

    @Autowired
    IssueRepository issueRepository;

//GET
    @Operation(
            summary = "Retrieve an Issue by Id",
            description = "Get an Issue object by specifying its id",
            tags = {"issues","get"}
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
            description = "Get a list of issues",
            tags = {"issues","get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")})
    })
    @GetMapping("/issues")
    public List<Issue> getAllIssues(@RequestParam(required = false) String title,
                                    @RequestParam(required = false) String state) {

        List<Issue> pageProjects;

        if(title == null && state == null)
            pageProjects=issueRepository.findAll();
            else
                if(state == null)
                    pageProjects = issueRepository.findByTitle(title);
                else
                    pageProjects = issueRepository.findByState(state);

        return pageProjects;


    }

//GET Issue's Comments
    @GetMapping("issues/{id}/comments")
    public List<Comment> getIssueComments(@Parameter(description = "id of the issue whose commits we search")
                                              @PathVariable String id) throws IssueNotFoundException {
        return getIssue(id).getComments(); }

}
