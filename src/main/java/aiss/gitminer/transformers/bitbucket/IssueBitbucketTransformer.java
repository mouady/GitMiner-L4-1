package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Issue;
import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import aiss.gitminer.transformers.bitbucket.users.ReporterBitbucketTransformer;

public class IssueBitbucketTransformer {

    public static Issue transform(IssueBitbucket bitbucketIssue) {
        Issue issue = new Issue();

        issue.setId(bitbucketIssue.getId().toString());
        issue.setTitle(bitbucketIssue.getTitle());
        issue.setDescription(bitbucketIssue.getContent().getRaw() != null ? bitbucketIssue.getContent().getRaw() : "");
        issue.setState(bitbucketIssue.getState());
        issue.setCreatedAt(bitbucketIssue.getCreatedOn());
        issue.setUpdatedAt(bitbucketIssue.getUpdatedOn());
        issue.setClosedAt(null);
        issue.setAuthor(ReporterBitbucketTransformer.transform(bitbucketIssue.getReporter()));



        return issue;
    }
}