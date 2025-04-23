package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.github.CommitGithub;

import java.util.List;

public class CommitGithubTransformer {

    public static Commit transformToCommit(CommitGithub commitGithub) {
        return new Commit(commitGithub.getSha(),
                "",
                commitGithub.getCommit().getMessage(),
                commitGithub.getCommit().getAuthor().getName(),
                commitGithub.getCommit().getAuthor().getEmail(),
                commitGithub.getCommit().getAuthor().getDate(),
                commitGithub.getUrl()
                );
    }

    public static List<Commit> transformToCommits(List<CommitGithub> commitsGithub) {
        return commitsGithub.stream()
                .map(CommitGithubTransformer::transformToCommit)
                .toList();
    }
}
