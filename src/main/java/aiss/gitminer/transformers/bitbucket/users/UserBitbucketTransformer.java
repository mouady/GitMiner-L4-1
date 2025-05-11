package aiss.gitminer.transformers.bitbucket.users;

import aiss.gitminer.model.User;
import aiss.gitminer.model.bitbucket.esclave.users.UserBitbucket;

public class UserBitbucketTransformer {

    public static User transform(UserBitbucket bitbucketUser) {
        User user = null;
        if (bitbucketUser != null) {
            user = new User(bitbucketUser.getUuid() == null ? "[NO ID]" : bitbucketUser.getUuid(),
                    bitbucketUser.getNickname() == null ? "[NO USERNAME]" : bitbucketUser.getNickname(),
                    bitbucketUser.getDisplayName(),
                    bitbucketUser.getLinks().getAvatar().getHref(),
                    bitbucketUser.getLinks().getHtml().getHref());
        }
        return user;
    }
}