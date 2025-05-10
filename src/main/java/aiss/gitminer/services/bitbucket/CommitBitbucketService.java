package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.CommitBitbucket;
import aiss.gitminer.util.DateUtils;
import aiss.gitminer.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        int commitsToRetrieve = (nCommits != null)
                ? nCommits
                : Environment.BITBUCKET_DEFAULT_NCOMMITS;
        int pagesToRetrieve = (maxPages != null)
                ? maxPages
                : Environment.BITBUCKET_DEFAULT_MAX_PAGES;

        String url = Environment.BITBUCKET_BASEURI
                + owner + "/"
                + repo
                + "/commits?=nCommits=" + 5;

        for (int i = 0; i < pagesToRetrieve && url != null; i++) {
            ResponseEntity<PaginatedCommits> resp = restTemplate.exchange(
                    url, HttpMethod.GET, entity, PaginatedCommits.class);
            PaginatedCommits page = resp.getBody();
            if (page == null || page.getValues().isEmpty()) {
                break;
            }
            if (page.getValues().size() >= nCommits) {
                res.addAll(page.getValues().subList(0, nCommits));
            }
            res.addAll(page.getValues());
            url = page.getNext();
        }

        return res;
    }

    private static class PaginatedCommits {
        private List<CommitBitbucket> values;
        private String next;

        public List<CommitBitbucket> getValues() { return values; }
        public String getNext() { return next; }
        public void setValues(List<CommitBitbucket> values) { this.values = values; }
        public void setNext(String next) { this.next = next; }
    }
}