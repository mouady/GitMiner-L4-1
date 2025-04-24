package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.github.CommitGithub;

import java.util.List;

public class CommitGithubTransformer {

    public static Commit transformToCommit(CommitGithub commitGithub) {
        return new Commit(commitGithub.getSha(),
                "", // No tiene sentido title en este caso
                commitGithub.getCommit().getMessage(),
                commitGithub.getCommit().getAuthor().getName(),
                commitGithub.getCommit().getAuthor().getEmail(),
                commitGithub.getCommit().getAuthor().getDate(),

                // Importante no seguir el patron: commitGithub.getCommit().getCommitter().[getName(),getEmail(),getDate()]
                // NO: commitGithub.getCommitter().[getName(), getEmail(), getDate()]
                commitGithub.getCommit().getCommitter().getName(),
                commitGithub.getCommit().getCommitter().getEmail(),
                commitGithub.getCommit().getCommitter().getDate(),
                commitGithub.getUrl()
                );
    }

    public static List<Commit> transformToCommits(List<CommitGithub> commitsGithub) {
        return commitsGithub.stream()
                .map(CommitGithubTransformer::transformToCommit)
                .toList();
    }
}
