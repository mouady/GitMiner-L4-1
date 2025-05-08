package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.RepositoryBitbucket;
import aiss.gitminer.model.github.RepositoryGithub;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import aiss.gitminer.util.Checkers;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RepositoryBitbucketService {

    @Autowired
    RestTemplate restTemplate;
    
    public RepositoryBitbucket getRepository(String owner, String repo) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<RepositoryGithub> entity = new HttpEntity<>(headers);

        String uri = Environment.BITBUCKET_BASEURI + owner + "/" + repo;

        ResponseEntity<RepositoryBitbucket> response = restTemplate.exchange(uri, HttpMethod.GET, entity, RepositoryBitbucket.class);
        return response.getBody();
    }
}
