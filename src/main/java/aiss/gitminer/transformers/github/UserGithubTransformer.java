package aiss.gitminer.transformers.github;

import aiss.gitminer.model.User;
import aiss.gitminer.model.github.UserGithub;

public class UserGithubTransformer {
    public static User transformToUser(UserGithub userGithub) {
        User res = null;

        if(userGithub != null) {
            res = new User(userGithub.getId(),
                    userGithub.getLogin(),
                    null, // No hay name en github
                    userGithub.getAvatarUrl(),
                    userGithub.getUrl()
            );
        }

        return res;
    }
}
