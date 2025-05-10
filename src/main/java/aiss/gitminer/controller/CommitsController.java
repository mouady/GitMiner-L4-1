package aiss.gitminer.controller;

import aiss.gitminer.exception.CommitNotFoundException;
import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name="Commits",description = "Commits extracted from a Project")
@RestController
@RequestMapping("/gitminer")
public class CommitsController {

    @Autowired
    CommitRepository commitRepository;

    //GET
        @Operation(
                summary = "Retrieve a Commit by Id",
                description = "Get a Commit object by specifying its id",
                tags = {"Commits","GET"}
        )
        @ApiResponses({
                @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = Commit.class)
                        ,mediaType = "application/json")}),
                @ApiResponse(responseCode = "404",content = {@Content(schema = @Schema()) })
        })
        @GetMapping("/commits/{id}")
        public Commit getCommit(@Parameter(description = "id of the commit to be searched")
                                    @PathVariable String id) throws CommitNotFoundException {
            Optional<Commit> commit = commitRepository.findById(id);
            if (commit.isPresent()) {
                return commit.get();
            }
            throw new CommitNotFoundException();
        }


}
