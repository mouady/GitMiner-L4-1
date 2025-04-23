package aiss.gitminer.services.github;

import aiss.gitminer.model.github.CommentGithub;
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
public class CommentGithubService {

    // IMPORTANTE: Usar autowired NO es conveniente en esta clase en concreto
    private final RestTemplate restTemplate = new RestTemplate();

    public List<CommentGithub> getAllCommentsFromIssue(String commentsUrl, Integer maxPages) {
        List<CommentGithub> res = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        if(Checkers.isTokenGithub(Environment.GITHUB_TOKEN)) {
            headers.set("Authorization", "Bearer " + Environment.GITHUB_TOKEN);
        }
        HttpEntity<CommentGithub[]> entity = new HttpEntity<>(headers);

        int pagesToRetrieve = maxPages != null ? maxPages : Environment.GITHUB_DEFAULT_MAX_PAGES;

        for(int page = 1; page <= pagesToRetrieve; page++) {
            String localUrl = commentsUrl + "?page=" + page;
            ResponseEntity<CommentGithub[]> localResponse = restTemplate.exchange(
                    localUrl, HttpMethod.GET, entity, CommentGithub[].class);
            List<CommentGithub> pageComments = Arrays.stream(localResponse.getBody()).toList();
            if (pageComments.isEmpty()) {
                break; // No more comments to retrieve
            } else {
                res.addAll(pageComments);
            }
        }

        return res;
    }
}
