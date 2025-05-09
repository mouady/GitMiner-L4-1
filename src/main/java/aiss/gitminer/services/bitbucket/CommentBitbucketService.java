package aiss.gitminer.services.bitbucket;

import aiss.gitminer.model.bitbucket.esclave.comments.CommentValue;
import aiss.gitminer.util.Environment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentBitbucketService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CommentValue> getAllCommentsFromIssue(String commentsUrl, Integer maxPages) {
        List<CommentValue> allComments = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        // Si tu API requiere auth, descomenta:
        // headers.setBearerAuth(Environment.BITBUCKET_TOKEN);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = commentsUrl;
        int pagesToRetrieve = maxPages != null
                ? maxPages
                : Environment.GITHUB_DEFAULT_MAX_PAGES;

        for (int i = 0; i < pagesToRetrieve && url != null; i++) {
            ResponseEntity<PaginatedComments> resp = restTemplate.exchange(
                    url, HttpMethod.GET, entity, PaginatedComments.class
            );

            PaginatedComments page = resp.getBody();
            if (page == null || page.getValues().isEmpty()) break;

            allComments.addAll(page.getValues());
            url = page.getNext();
        }

        return allComments;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class PaginatedComments {
        private List<CommentValue> values;
        private String next;

        public List<CommentValue> getValues() {
            return values;
        }
        public void setValues(List<CommentValue> values) {
            this.values = values;
        }
        public String getNext() {
            return next;
        }
        public void setNext(String next) {
            this.next = next;
        }
    }
}