package aiss.gitminer.transformers.bitbucket;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.bitbucket.esclave.CommitBitbucket;

import java.util.List;

public class CommitBitbucketTransformer {

    public static Commit transformToCommit(CommitBitbucket commitBitbucket) {
        int aperturacorreo = commitBitbucket.getAuthor().getRaw().indexOf('<');
        int cierrecorreo = commitBitbucket.getAuthor().getRaw().indexOf('>');
        return new Commit(commitBitbucket.getHash(),
                commitBitbucket.getSummary().getRaw(),
                commitBitbucket.getMessage(),
                commitBitbucket.getAuthor().getRaw().substring(0, aperturacorreo).trim(),
                commitBitbucket.getAuthor().getRaw().substring(aperturacorreo + 1, cierrecorreo).trim(),
                commitBitbucket.getDate(),
                // * NOTA
                commitBitbucket.getLinks().getSelf().getHref()
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

    public static List<Commit> transformToCommits(List<CommitBitbucket> commitBitbucket) {
        return commitBitbucket.stream()
                .map(CommitBitbucketTransformer::transformToCommit)
                .toList();
    }
}
