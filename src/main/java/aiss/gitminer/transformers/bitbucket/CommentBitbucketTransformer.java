package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.bitbucket.esclave.comments.CommentValue;
import aiss.gitminer.transformers.bitbucket.users.UserBitbucketTransformer;


import java.util.List;

public class CommentBitbucketTransformer {
    public static Comment transformCommentValueToComment(CommentValue commentValue) {

        return new Comment(commentValue.getId().toString(),
                commentValue.getContent().getRaw(),
                UserBitbucketTransformer.transform(commentValue.getUser()),
                commentValue.getCreatedOn(),
                commentValue.getUpdatedOn());
    }

    public static List<Comment> transformListOfCommentValuesToComments(List<CommentValue> commentValues) {
        return commentValues.stream()
                .map(CommentBitbucketTransformer::transformCommentValueToComment)
                .toList();
    }
}
