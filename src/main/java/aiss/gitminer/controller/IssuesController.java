package aiss.gitminer.controller;

import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitminer")
public class IssuesController {

    @Autowired
    IssueRepository issueRepository;

    @GetMapping("/issues/{id}")
    public Issue getIssue(@PathVariable String id) { return issueRepository.findById(id).orElse(null); }

    @GetMapping("/issues")
    public List<Issue> getAllIssues() {return issueRepository.findAll();
    }

    @GetMapping("issues/{id}/comments")
    public List<Comment> getIssueComments(@PathVariable String id) {
        return getIssue(id).getComments(); }

}
