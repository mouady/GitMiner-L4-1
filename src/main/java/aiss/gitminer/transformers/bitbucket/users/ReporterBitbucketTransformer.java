package aiss.gitminer.transformers.bitbucket.users;

import aiss.gitminer.model.User;
import aiss.gitminer.model.bitbucket.esclave.users.Reporter;

public class ReporterBitbucketTransformer {

    public static User transform(Reporter bitbucketReporter) {
        return new User(bitbucketReporter.getAccountId(),
                bitbucketReporter.getNickname(),
                bitbucketReporter.getDisplayName(),
                bitbucketReporter.getLinks().getAvatar().getHref(),
                bitbucketReporter.getLinks().getHtml().getHref());

    }
}