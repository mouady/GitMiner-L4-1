
package aiss.gitminer.model.bitbucket.esclave.comments;

import java.util.LinkedHashMap;
import java.util.Map;

import aiss.gitminer.model.bitbucket.esclave.IssueBitbucket;
import aiss.gitminer.model.bitbucket.esclave.links.Links__3;
import aiss.gitminer.model.bitbucket.esclave.users.UserBitbucket;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "created_on",
    "updated_on",
    "content",
    "user",
    "issue",
    "links"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentValue {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    private String updatedOn;
    @JsonProperty("content")
    private Content content;
    @JsonProperty("user")
    private UserBitbucket user;
    @JsonProperty("issue")
    private IssueBitbucket issue;
    @JsonProperty("links")
    private Links__3 links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("updated_on")
    public String getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updated_on")
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("user")
    public UserBitbucket getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(UserBitbucket user) {
        this.user = user;
    }

    @JsonProperty("issue")
    public IssueBitbucket getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(IssueBitbucket issue) {
        this.issue = issue;
    }

    @JsonProperty("links")
    public Links__3 getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links__3 links) {
        this.links = links;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Value{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn=" + updatedOn +
                ", content=" + content +
                ", user=" + user +
                ", issue=" + issue +
                ", links=" + links +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
