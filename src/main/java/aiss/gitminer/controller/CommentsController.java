package aiss.gitminer.controller;

import aiss.gitminer.exception.CommentNotFoundException;
import aiss.gitminer.exception.IssueNotFoundException;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.github.CommentGithub;
import aiss.gitminer.repository.CommentRepository;
import aiss.gitminer.services.github.CommentGithubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gitminer")
public class CommentsController {

    @Autowired
    CommentRepository commentRepository;

//GET
    @Operation(
            summary = "Retrieve a Comment by Id",
            description = "Get a Comment object by specifying its id",
            tags = {"issues","get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",content = {@Content(schema = @Schema()) })
    })
    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable String id) throws CommentNotFoundException {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        }
        throw new CommentNotFoundException();
    }

//GET ALL
    @Operation(
            summary = "Retrieve a list of comments",
            description = "Get the list of comments",
            tags = {"issues","get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Issue.class)
                    ,mediaType = "application/json")})
    })
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
