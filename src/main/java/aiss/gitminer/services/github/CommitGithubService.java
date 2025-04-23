package aiss.gitminer.services.github;

import aiss.gitminer.model.github.CommitGithub;
import aiss.gitminer.util.DateUtils;
import aiss.gitminer.util.Environment;
import aiss.gitminer.util.Checkers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommitGithubService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Retrieves all commits from a given repository.
     *
     * @param owner         The owner of the repository.
     * @param repo          The name of the repository.
     * @param sinceCommits   La operación devolverá los commits enviados en los últimos X días, siendo
     * X el valor introducido como parámetro.
     * @param maxPages      The maximum number of pages to retrieve.
     * @return A list of CommitGithub objects representing the commits in the repository.
     */
    public List<CommitGithub> getAllCommits(String owner, String repo, Integer sinceCommits, Integer maxPages) {
        List<CommitGithub> res = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        if(Checkers.isTokenGithub(Environment.GITHUB_TOKEN)) headers.set("Authorization", "Bearer " + Environment.GITHUB_TOKEN);
        HttpEntity<CommitGithub[]> entity = new HttpEntity<>(headers);

        String commitsToRetrieve = sinceCommits != null ? DateUtils.getDateMinusDays(sinceCommits) : Environment.GITHUB_DEFAULT_SINCE_COMMITS;
        int pagesToRetrieve = maxPages != null ? maxPages : Environment.GITHUB_DEFAULT_MAX_PAGES;

        // Usamos since ya que no hay más parametros que puedan filtrar por fecha (aunque este devuelva los commits
        // actualizados, que no envidados). Tener en cuenta que authored_date NO es el criterio por el que se filtran
        // de cara a comprobarlo con Postman
        String uri = Environment.GITHUB_BASEURI + owner + "/" + repo + "/commits" + "?since=" + commitsToRetrieve;

        for(int page = 1; page <= pagesToRetrieve; page++) {
            String localUri = uri + "&page=" + page;
            ResponseEntity<CommitGithub[]> localResponse = restTemplate.exchange(
                    localUri, HttpMethod.GET, entity, CommitGithub[].class);
            List<CommitGithub> pageCommits = Arrays.stream(localResponse.getBody()).toList();
            if (pageCommits.isEmpty()) {
                break; // No more commits to retrieve
            } else {
                res.addAll(pageCommits);
            }
        }

        return res;
    }


}
