package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.RepositoryBitbucket;
import aiss.gitminer.model.github.RepositoryGithub;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    public RepositoryBitbucket getRepository(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<RepositoryGithub> entity = new HttpEntity<>(headers);
        String uri = Environment.BITBUCKET_BASEURI + owner + "/" + repo;
        ResponseEntity<RepositoryBitbucket> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                RepositoryBitbucket.class
        );
        return response.getBody();
    }
}