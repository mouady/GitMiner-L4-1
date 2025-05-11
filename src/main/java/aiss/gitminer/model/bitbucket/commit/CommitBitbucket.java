
package aiss.gitminer.model.bitbucket.commit;

import aiss.gitminer.model.bitbucket.links.LinksBitbucket;
import aiss.gitminer.model.bitbucket.users.AuthorBitbucket;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "hash",
    "date",
    "author",
    "message",
    "summary",
    "links",
    "parents",
    "rendered",
    "repository"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitBitbucket {

    @JsonProperty("hash")
    private String hash;
    @JsonProperty("summary")
    private CommitSummaryBitbucket commitSummaryBitbucket;
    @JsonProperty("message")
    private String message;
    @JsonProperty("author")
    private AuthorBitbucket authorBitbucket;
    @JsonProperty("date")
    private String date;
    @JsonProperty("links")
    private LinksBitbucket linksBitbucket;


    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("author")
    public AuthorBitbucket getAuthor() {
        return authorBitbucket;
    }

    @JsonProperty("author")
    public void setAuthor(AuthorBitbucket authorBitbucket) {
        this.authorBitbucket = authorBitbucket;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("summary")
    public CommitSummaryBitbucket getSummary() {
        return commitSummaryBitbucket;
    }

    @JsonProperty("summary")
    public void setSummary(CommitSummaryBitbucket commitSummaryBitbucket) {
        this.commitSummaryBitbucket = commitSummaryBitbucket;
    }

    @JsonProperty("links")
    public LinksBitbucket getLinks() {
        return linksBitbucket;
    }

    @JsonProperty("links")
    public void setLinks(LinksBitbucket linksBitbucket) {
        this.linksBitbucket = linksBitbucket;
    }

}
