package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Issue;
import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import aiss.gitminer.transformers.bitbucket.users.ReporterBitbucketTransformer;
import aiss.gitminer.transformers.bitbucket.users.UserBitbucketTransformer;

public class IssueBitbucketTransformer {

    public static Issue transform(IssueBitbucket bitbucketIssue) {
        return new Issue(bitbucketIssue.getId().toString(),
                bitbucketIssue.getTitle(),
                bitbucketIssue.getContent().getRaw(),
                bitbucketIssue.getState(),
                bitbucketIssue.getCreatedOn(),
                bitbucketIssue.getUpdatedOn(),
                null, // No lo proporciona Bitbucket
                null, // No existe en Bitbucket
                UserBitbucketTransformer.transform(bitbucketIssue.getReporter()),
                UserBitbucketTransformer.transform(bitbucketIssue.getAssignee()),
                bitbucketIssue.getVotes(),
                null);
    }
}