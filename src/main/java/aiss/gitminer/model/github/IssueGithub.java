
package aiss.gitminer.model.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "node_id",
    "url",
    "repository_url",
    "labels_url",
    "comments_url",
    "events_url",
    "html_url",
    "number",
    "state",
    "title",
    "body",
    "user",
    "labels",
    "assignee",
    "assignees",
    "milestone",
    "locked",
    "active_lock_reason",
    "comments",
    "pull_request",
    "closed_at",
    "created_at",
    "updated_at",
    "closed_by",
    "author_association",
    "state_reason"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class IssueGithub {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body; // Description en Issue
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private String closedAt;
    @JsonProperty("labels")
    private List<LabelGithub> labelGithubs;

    @JsonProperty("number")
    private Integer number; // Número de Issue, puede ser util en el futuro
    @JsonProperty("comments")
    private Integer comments; // Muy util para saber si existen comentarios

    @JsonProperty("user")
    private UserGithub user;
    @JsonProperty("assignee")
    private UserGithub assignee;





    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("user")
    public UserGithub getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(UserGithub user) {
        this.user = user;
    }

    @JsonProperty("labels")
    public List<LabelGithub> getLabels() {
        return labelGithubs;
    }

    @JsonProperty("labels")
    public void setLabels(List<LabelGithub> labelGithubs) {
        this.labelGithubs = labelGithubs;
    }

    @JsonProperty("assignee")
    public UserGithub getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(UserGithub userGithub) {
        this.assignee = userGithub;
    }

    @JsonProperty("closed_at")
    public String getClosedAt() {
        return closedAt;
    }

    @JsonProperty("closed_at")
    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }
    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }
    @JsonProperty("comments")
    public Integer getComments() {
        return comments;
    }
    @JsonProperty("comments")
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IssueGithub.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("comments_url");
        sb.append('=');
        sb.append(((this.commentsUrl == null)?"<null>":this.commentsUrl));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("body");
        sb.append('=');
        sb.append(((this.body == null)?"<null>":this.body));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labelGithubs == null)?"<null>":this.labelGithubs));
        sb.append(',');
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null)?"<null>":this.assignee));
        sb.append(',');
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closedAt == null)?"<null>":this.closedAt));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
