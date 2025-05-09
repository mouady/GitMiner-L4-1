package aiss.gitminer.transformers.bitbucket.users;

import aiss.gitminer.model.User;
import aiss.gitminer.model.bitbucket.esclave.users.UserBitbucket;

public class UserBitbucketTransformer {

    public static User transform(UserBitbucket bitbucketUser) {
        User user = new User();

        user.setId(bitbucketUser.getAccountId());
        user.setName(bitbucketUser.getUsername());
        user.setAvatarUrl(bitbucketUser.getLinks().getAvatar().getHref());


        return user;
    }
}