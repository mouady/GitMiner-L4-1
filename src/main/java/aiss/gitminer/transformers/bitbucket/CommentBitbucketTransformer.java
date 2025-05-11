package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.bitbucket.comments.CommentValueBitbucket;


import java.util.List;

public class CommentBitbucketTransformer {
    public static Comment transformCommentValueToComment(CommentValueBitbucket commentValueBitbucket) {

        return new Comment(commentValueBitbucket.getId().toString(),
                commentValueBitbucket.getContent().getRaw() == null ? "[NO BODY]" : commentValueBitbucket.getContent().getRaw(), // Hay veces que no hay body
                UserBitbucketTransformer.transform(commentValueBitbucket.getUser()),
                commentValueBitbucket.getCreatedOn(),
                commentValueBitbucket.getUpdatedOn());
    }

    public static List<Comment> transformListOfCommentValuesToComments(List<CommentValueBitbucket> commentValuesBitbucket) {
        return commentValuesBitbucket.stream()
                .map(CommentBitbucketTransformer::transformCommentValueToComment)
                .toList();
    }
}
