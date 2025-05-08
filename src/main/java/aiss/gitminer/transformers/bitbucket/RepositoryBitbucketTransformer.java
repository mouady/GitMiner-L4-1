package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Project;
import aiss.gitminer.model.bitbucket.RepositoryBitbucket;

public class RepositoryBitbucketTransformer {

    public static Project transformToProject(RepositoryBitbucket repo) {
        return new Project(repo.getUuid(),
                repo.getName(),
                repo.getWebsite(),
                null,
                null);
    }
}
