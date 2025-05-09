package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Issue;
import aiss.gitminer.model.bitbucket.IssueBitbucket;

public class IssueBitbucketTransformer {

    public static Issue transform(IssueBitbucket bitbucketIssue) {
        Issue issue = new Issue();

        issue.setId(bitbucketIssue.getId().toString());
        issue.setTitle(bitbucketIssue.getTitle());
        issue.setState(bitbucketIssue.getState());
        if (bitbucketIssue.getReporter() != null)
            issue.setAuthor(ReporterBitbucketTransformer.transform(bitbucketIssue.getReporter()));
        issue.setCreatedAt(bitbucketIssue.getCreatedOn());
        issue.setDescription(bitbucketIssue.getContent().getRaw() != null ? bitbucketIssue.getContent().getRaw() : "");

        return issue;
    }
}