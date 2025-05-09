package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.bitbucket.CommitBitbucket;
import aiss.gitminer.model.github.CommitGithub;

import java.util.List;

public class CommitBitbucketTransformer {

    public static Commit transformToCommit(CommitBitbucket commitBitbucket) {
        return new Commit(commitBitbucket.getHash(),
                null, // No tiene sentido title en este caso
                commitBitbucket.getMessage(),
                commitBitbucket.getAuthor().getRaw(),
                null,
                commitBitbucket.getDate(),
                // * NOTA
                commitBitbucket.getLinks().toString()
                );

        /*
        NOTA
        En el caso de que se use el modelo antiguo agregar:
        // Importante no seguir el patron: commitBitbucket.getCommit().getCommitter().[getName(),getEmail(),getDate()]
                // NO: commitBitbucket.getCommitter().[getName(), getEmail(), getDate()]
                commitBitbucket.getCommit().getCommitter().getName(),
                commitBitbucket.getCommit().getCommitter().getEmail(),
                commitBitbucket.getCommit().getCommitter().getDate(),
         */
    }

    public static List<Commit> transformToCommits(List<CommitBitbucket> commitBitbuckets) {
        return commitBitbuckets.stream()
                .map(CommitBitbucketTransformer::transformToCommit)
                .toList();
    }
}
