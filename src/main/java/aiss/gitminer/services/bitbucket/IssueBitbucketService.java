package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.github.IssueGithub;
import aiss.gitminer.util.Checkers;
import aiss.gitminer.util.DateUtils;
import aiss.gitminer.util.Environment;
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
public class IssueBitbucketService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Retrieves all issues from a given repository.
     *
     * @param owner         The owner of the repository.
     * @param repo          The name of the repository.
     * @param sinceIssues   La operación devolverá los issues actualizados en los últimos X días, siendo
     * X el valor introducido como parámetro.
     * @param maxPages      The maximum number of pages to retrieve.
     * @return A list of IssueGithub objects representing the issues in the repository.
     */
    public List<IssueGithub> getAllIssuesFromRepo(String owner, String repo, Integer sinceIssues, Integer maxPages) {
        List<IssueGithub> res = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        if(Checkers.isTokenGithub(Environment.GITHUB_TOKEN)) headers.set("Authorization", "Bearer " + Environment.GITHUB_TOKEN);
        HttpEntity<IssueGithub[]> entity = new HttpEntity<>(headers);

        String issuesToRetrieve = sinceIssues != null ? DateUtils.getDateMinusDays(sinceIssues) : Environment.GITHUB_DEFAULT_SINCE_ISSUES;
        int pagesToRetrieve = maxPages != null ? maxPages : Environment.GITHUB_DEFAULT_MAX_PAGES;

        String uri = Environment.GITHUB_BASEURI + owner + "/" + repo + "/issues" + "?since=" + issuesToRetrieve;

        for(int page = 1; page <= pagesToRetrieve; page++) {
            String localUri = uri + "&page=" + page;
            ResponseEntity<IssueGithub[]> localResponse = restTemplate.exchange(
                    localUri, HttpMethod.GET, entity, IssueGithub[].class);
            List<IssueGithub> pageIssues = Arrays.stream(localResponse.getBody()).toList();
            if (pageIssues.isEmpty()) {
                break; // No more issues to retrieve
            } else {
                res.addAll(pageIssues);
            }
        }

        return res;
    }


}
