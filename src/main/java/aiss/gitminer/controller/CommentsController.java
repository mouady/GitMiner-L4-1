package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.github.CommentGithub;
import aiss.gitminer.repository.CommentRepository;
import aiss.gitminer.services.github.CommentGithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitminer")
public class CommentsController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable String id) {
        return commentRepository.findById(id).orElse(null);
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
