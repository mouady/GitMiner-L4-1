
package aiss.gitminer.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author",
    "committer",
    "message",
    "tree",
    "url",
    "comment_count",
    "verification"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class CommitGithub__1 {

    @JsonProperty("author")
    private CommitAuthorGithub commitAuthorGithub;
    @JsonProperty("committer")
    private CommitterGithub committerGithub;
    @JsonProperty("message")
    private String message;
    @JsonProperty("url")
    private String url;
    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("author")
    public CommitAuthorGithub getAuthor() {
        return commitAuthorGithub;
    }

    @JsonProperty("author")
    public void setAuthor(CommitAuthorGithub commitAuthorGithub) {
        this.commitAuthorGithub = commitAuthorGithub;
    }

    @JsonProperty("committer")
    public CommitterGithub getCommitter() {
        return committerGithub;
    }

    @JsonProperty("committer")
    public void setCommitter(CommitterGithub committerGithub) {
        this.committerGithub = committerGithub;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitGithub__1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("author");
        sb.append('=');
        sb.append(((this.commitAuthorGithub == null)?"<null>":this.commitAuthorGithub));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committerGithub == null)?"<null>":this.committerGithub));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("tree");
        sb.append('=');
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("commentCount");
        sb.append('=');
        sb.append(((this.commentCount == null)?"<null>":this.commentCount));
        sb.append(',');
        sb.append("verification");
        sb.append('=');
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
