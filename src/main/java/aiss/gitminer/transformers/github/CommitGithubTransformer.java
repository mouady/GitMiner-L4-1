package aiss.gitminer.transformers.github;

import aiss.gitminer.model.Commit;
import aiss.gitminer.model.github.CommitGithub;
import aiss.gitminer.util.Utils;

import java.util.List;

public class CommitGithubTransformer {

    public static Commit transformToCommit(CommitGithub commitGithub) {
        List<String> tituloYMensaje = Utils.splitIntoTitleAndMessage(commitGithub.getCommit().getMessage());

        return new Commit(commitGithub.getSha(),
                tituloYMensaje.get(0),
                tituloYMensaje.get(1),
                commitGithub.getCommit().getAuthor().getName(),
                commitGithub.getCommit().getAuthor().getEmail(),
                commitGithub.getCommit().getAuthor().getDate(),
                // * NOTA
                commitGithub.getUrl()
                );

        /*
        NOTA
        En el caso de que se use el modelo antiguo agregar:
        // Importante no seguir el patron: commitGithub.getCommit().getCommitter().[getName(),getEmail(),getDate()]
                // NO: commitGithub.getCommitter().[getName(), getEmail(), getDate()]
                commitGithub.getCommit().getCommitter().getName(),
                commitGithub.getCommit().getCommitter().getEmail(),
                commitGithub.getCommit().getCommitter().getDate(),
         */
    }

    public static List<Commit> transformToCommits(List<CommitGithub> commitsGithub) {
        return commitsGithub.stream()
                .map(CommitGithubTransformer::transformToCommit)
                .toList();
    }
}
