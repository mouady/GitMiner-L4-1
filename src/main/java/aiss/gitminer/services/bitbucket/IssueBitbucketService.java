package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import aiss.gitminer.util.Environment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    public List<IssueBitbucket> getAllIssuesFromRepo(String workspace, String repoSlug, Integer nIssues, Integer maxPages) {
        List<IssueBitbucket> results = new ArrayList<>();
        String baseUrl = Environment.BITBUCKET_BASEURI;
        String nextUrl = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .pathSegment(workspace, repoSlug, "issues")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(Environment.BITBUCKET_USER, Environment.BITBUCKET_APP_PASSWORD);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Void> request = new HttpEntity<>(headers);

        int pages = maxPages != null ? maxPages : Environment.BITBUCKET_DEFAULT_MAX_PAGES;
        for (int page = 1; page <= pages && nextUrl != null; page++) {
            String pagedUrl = UriComponentsBuilder
                    .fromHttpUrl(nextUrl)
                    .replaceQueryParam("page", page)
                    .toUriString();
            ResponseEntity<PaginatedIssues> resp = restTemplate.exchange(
                    pagedUrl, HttpMethod.GET, request, PaginatedIssues.class);
            PaginatedIssues body = resp.getBody();
            if (body == null || body.getValues() == null || body.getValues().isEmpty()) {
                break;
            }
            results.addAll(body.getValues());
            nextUrl = body.getNext();
        }
        return results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class PaginatedIssues {
        private List<IssueBitbucket> values;
        private String next;
        public List<IssueBitbucket> getValues() { return values; }
        public void setValues(List<IssueBitbucket> values) { this.values = values; }
        public String getNext() { return next; }
        public void setNext(String next) { this.next = next; }
    }
}