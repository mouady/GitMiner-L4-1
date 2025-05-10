package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
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
public class IssueBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Retrieves up to nIssues from a given repository, following Bitbucket's HATEOAS pagination.
     */
    public List<IssueBitbucket> getAllIssuesFromRepo(String owner,
                                                     String repo,
                                                     Integer nIssues,
                                                     Integer maxPages) {
        List<IssueBitbucket> res = new ArrayList<>();
        HttpEntity<Void> entity = new HttpEntity<>(new HttpHeaders());

        int issuesToRetrieve = nIssues != null
                ? nIssues
                : Environment.BITBUCKET_DEFAULT_NISSUES;
        int pagesToRetrieve = maxPages != null
                ? maxPages
                : Environment.BITBUCKET_DEFAULT_MAX_PAGES;

        String url = Environment.BITBUCKET_BASEURI
                + owner + "/"
                + repo
                + "/issues?pagelen=" + issuesToRetrieve;

        for (int i = 0; i < pagesToRetrieve && url != null; i++) {
            ResponseEntity<PaginatedIssues> resp = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    PaginatedIssues.class
            );
            PaginatedIssues page = resp.getBody();
            if (page == null || page.getValues().isEmpty()) {
                break;
            }

            res.addAll(page.getValues());
            if (res.size() >= issuesToRetrieve) {
                return res.subList(0, issuesToRetrieve);
            }

            url = page.getNext();
        }

        return res;
    }

    private static class PaginatedIssues {
        private List<IssueBitbucket> values;
        private String next;

        public List<IssueBitbucket> getValues() {
            return values;
        }
        public String getNext() {
            return next;
        }
        public void setValues(List<IssueBitbucket> values) {
            this.values = values;
        }
        public void setNext(String next) {
            this.next = next;
        }
    }
}