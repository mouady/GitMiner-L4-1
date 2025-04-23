package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Project;
import aiss.gitminer.model.github.RepositoryGithub;

public class RepositoryGithubTransformer {

    public static Project transformToProject(RepositoryGithub repo) {
        return new Project(repo.getId().toString(),
                repo.getName(),
                repo.getHtmlUrl(),
                null,
                null);
    }
}
