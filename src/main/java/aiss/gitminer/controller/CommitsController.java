package aiss.gitminer.controller;

import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitminer")
public class CommitsController {

    @Autowired
    CommitRepository commitRepository;

    @GetMapping("/commits/{id}")
    public Commit getCommit(@PathVariable String id) { return commitRepository.findById(id).orElse(null); }


}
