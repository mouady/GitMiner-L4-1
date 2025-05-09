package aiss.gitminer.transformers.bitbucket.users;

import aiss.gitminer.model.User;
import aiss.gitminer.model.bitbucket.esclave.users.Reporter;

public class ReporterBitbucketTransformer {

    public static User transform(Reporter bitbucketReporter) {
        User user = new User();

        user.setId(bitbucketReporter.getAccountId());
        user.setName(bitbucketReporter.getDisplayName());
        // Lo mas parecido al url del avatar
        user.setAvatarUrl(bitbucketReporter.getLinks().getHtml().getHref());


        return user;
    }
}