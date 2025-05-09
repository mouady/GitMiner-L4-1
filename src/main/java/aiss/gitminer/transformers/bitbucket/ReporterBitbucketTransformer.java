package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.User;
import aiss.gitminer.model.bitbucket.Reporter;
import aiss.gitminer.model.bitbucket.UserBitbucket;

public class ReporterBitbucketTransformer {

    public static User transform(Reporter bitbucketReporter) {
        User user = new User();

        user.setId(bitbucketReporter.getAccountId());
        user.setName(bitbucketReporter.getDisplayName());
        user.setAvatarUrl(null);


        return user;
    }
}