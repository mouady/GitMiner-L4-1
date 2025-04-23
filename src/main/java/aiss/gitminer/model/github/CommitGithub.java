
package aiss.gitminer.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sha",
    "node_id",
    "commit",
    "url",
    "html_url",
    "comments_url",
    "author",
    "committer",
    "parents"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class CommitGithub {

    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("commit")
    private CommitGithub__1 commit;
    @JsonProperty("url")
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("author")
    private CommitAuthorGithub commitAuthorGithub;
    @JsonProperty("committer")
    private CommitterGithub committerGithub;

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("commit")
    public CommitGithub__1 getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(CommitGithub__1 commit) {
        this.commit = commit;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitGithub.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sha");
        sb.append('=');
        sb.append(((this.sha == null)?"<null>":this.sha));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
        sb.append(',');
        sb.append("commit");
        sb.append('=');
        sb.append(((this.commit == null)?"<null>":this.commit));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("commentsUrl");
        sb.append('=');
        sb.append(((this.commentsUrl == null)?"<null>":this.commentsUrl));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.commitAuthorGithub == null)?"<null>":this.commitAuthorGithub));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committerGithub == null)?"<null>":this.committerGithub));
        sb.append(',');
        sb.append("parents");
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
