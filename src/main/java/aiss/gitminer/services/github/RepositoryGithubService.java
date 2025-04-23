package aiss.gitminer.services.github;

import aiss.gitminer.model.github.RepositoryGithub;
import aiss.gitminer.util.Checkers;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryGithubService {

    @Autowired
    RestTemplate restTemplate;
    
    public RepositoryGithub getRepository(String owner, String repo) {

        HttpHeaders headers = new HttpHeaders();
        if(Checkers.isTokenGithub(Environment.GITHUB_TOKEN)) headers.set("Authorization", "Bearer " + Environment.GITHUB_TOKEN);
        HttpEntity<RepositoryGithub> entity = new HttpEntity<>(headers);

        String uri = Environment.GITHUB_BASEURI + owner + "/" + repo;

        ResponseEntity<RepositoryGithub> response = restTemplate.exchange(uri, HttpMethod.GET, entity, RepositoryGithub.class);
        return response.getBody();
    }
}
