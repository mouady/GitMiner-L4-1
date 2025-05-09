package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.RepositoryBitbucket;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Obtiene la información de un repositorio en Bitbucket.
     *
     * @param owner Workspace o usuario que posee el repositorio.
     * @param repo  Nombre del repositorio.
     * @return Un objeto RepositoryBitbucket con los datos del repositorio.
     */
    public RepositoryBitbucket getRepository(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Environment.BITBUCKET_TOKEN);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String uri = Environment.BITBUCKET_BASEURI
                + "repositories/"
                + owner + "/"
                + repo;

        ResponseEntity<RepositoryBitbucket> response = restTemplate.exchange(
                uri, HttpMethod.GET, entity, RepositoryBitbucket.class);

        return response.getBody();
    }
}