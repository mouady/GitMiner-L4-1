package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;
import aiss.gitminer.model.github.CommentGithub;

import java.util.List;

public class CommentGithubTransformer {
    public static Comment transformToComment(CommentGithub commentGithub) {

        User author = UserGithubTransformer.transformToUser(commentGithub.getUser());

        return new Comment(commentGithub.getId(),
                commentGithub.getBody(),
                author,
                commentGithub.getCreated_at(),
                commentGithub.getUpdated_at());
    }

    public static List<Comment> transformToComments(List<CommentGithub> commentsGithub) {
        return commentsGithub.stream()
                .map(CommentGithubTransformer::transformToComment)
                .toList();
    }
}
