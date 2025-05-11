
package aiss.gitminer.model.bitbucket;

import aiss.gitminer.model.bitbucket.users.UserBitbucket;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "repository",
    "links",
    "title",
    "content",
    "reporter",
    "assignee",
    "created_on",
    "edited_on",
    "updated_on",
    "state",
    "kind",
    "milestone",
    "component",
    "priority",
    "version",
    "votes",
    "watches"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueBitbucket {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private ContentBitbucket content;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    private String updatedOn;
    @JsonProperty("reporter")
    private UserBitbucket reporter;
    @JsonProperty("assignee")
    private UserBitbucket assignee;
    @JsonProperty("votes")
    private Integer votes;


    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("content")
    public ContentBitbucket getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(ContentBitbucket content) {
        this.content = content;
    }

    @JsonProperty("reporter")
    public UserBitbucket getReporter() {
        return reporter;
    }

    @JsonProperty("reporter")
    public void setReporter(UserBitbucket reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("assignee")
    public UserBitbucket getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(UserBitbucket assignee) {
        this.assignee = assignee;
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

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("votes")
    public Integer getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}
