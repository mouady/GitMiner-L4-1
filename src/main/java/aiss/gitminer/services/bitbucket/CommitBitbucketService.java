package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.CommitBitbucket;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommitBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CommitBitbucket> getAllCommits(String owner, String repo, Integer nCommits, Integer maxPages) {
        List<CommitBitbucket> res = new ArrayList<>();
        HttpEntity<Void> entity = new HttpEntity<>(new HttpHeaders());
        int commitsToRetrieve = nCommits != null
                ? nCommits
                : Environment.BITBUCKET_DEFAULT_NCOMMITS;
        int pagesToRetrieve = maxPages != null
                ? maxPages
                : Environment.BITBUCKET_DEFAULT_MAX_PAGES;
        String url = Environment.BITBUCKET_BASEURI + owner + "/" + repo + "/commits?pagelen=" + commitsToRetrieve;
        for (int i = 0; i < pagesToRetrieve && url != null; i++) {
            ResponseEntity<PaginatedCommits> resp = restTemplate.exchange(url, HttpMethod.GET, entity, PaginatedCommits.class);
            PaginatedCommits page = resp.getBody();
            if (page == null || page.getValues().isEmpty()) break;
            res.addAll(page.getValues());
            if (page.getValues().size() > commitsToRetrieve) {
                res.addAll(page.getValues().subList(0, commitsToRetrieve));
                return res;
            }
            url = page.getNext();
        }
        return res;
    }

    // Usamos un wrapper para aprovechar el campo 'next' del json que se nos devuelve
    private static class PaginatedCommits {
        private List<CommitBitbucket> values;
        private String next;
        public List<CommitBitbucket> getValues() { return values; }
        public String getNext() { return next; }
        public void setValues(List<CommitBitbucket> values) { this.values = values; }
        public void setNext(String next) { this.next = next; }
    }
}