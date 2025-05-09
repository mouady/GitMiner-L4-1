package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.bs.User;
import aiss.gitminer.model.bitbucket.esclave.comments.CommentBitbucket;
import aiss.gitminer.model.github.CommentGithub;
import aiss.gitminer.util.Checkers;
import aiss.gitminer.util.Environment;
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
public class CommentBitbucketService {

    // IMPORTANTE: Usar autowired NO es conveniente en esta clase en concreto
    private final RestTemplate restTemplate = new RestTemplate();

    public List<CommentBitbucket> getAllCommentsFromIssue(String commentsUrl, Integer maxPages) {
        List<CommentBitbucket> res = new ArrayList<>();

        int pagesToRetrieve = maxPages != null ? maxPages : Environment.GITHUB_DEFAULT_MAX_PAGES;

        for(int page = 1; page <= pagesToRetrieve; page++) {
            String localUrl = commentsUrl + "?page=" + page;
            ResponseEntity<CommentBitbucket[]> localResponse = restTemplate.exchange(
                    localUrl, HttpMethod.GET, entity, CommentBitbucket[].class);
            List<CommentBitbucket> pageComments = Arrays.stream(localResponse.getBody()).toList();
            if (pageComments.isEmpty()) {
                break; // No more comments to retrieve
            } else {
                res.addAll(pageComments);
            }
        }

        return res;
    }

    public User getUserFromBitbucket(String id) {
        String url = Environment.BITBUCKET_BASEURI + "/users/" + id;

        try {
            String auth = User. + ":" + appPassword;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Basic " + encodedAuth);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Users> response = restTemplate.exchange(url, HttpMethod.GET, entity, Users.class);
            if (response.getBody() == null) {
                logger.warn("La respuesta de la API de Bitbucket es nula para la URL: {}", url);
                return null;
            }

            return response.getBody();
        } catch (RestClientException e) {
            logger.error("Error al realizar la solicitud a la API de Bitbucket: {}", e.getMessage());
            return null;
        }
    }
}
