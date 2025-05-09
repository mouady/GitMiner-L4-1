
package aiss.gitminer.model.bitbucket.esclave;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import aiss.gitminer.model.bitbucket.bs.*;
import aiss.gitminer.model.bitbucket.esclave.users.Reporter;
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

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("links")
    private Links__1 links;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private Content content;
    @JsonProperty("reporter")
    private Reporter reporter;
    @JsonProperty("assignee")
    private Object assignee;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("edited_on")
    private Object editedOn;
    @JsonProperty("updated_on")
    private String updatedOn;
    @JsonProperty("state")
    private String state;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("milestone")
    private Milestone milestone;
    @JsonProperty("component")
    private Component component;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("version")
    private Object version;
    @JsonProperty("votes")
    private Integer votes;
    @JsonProperty("watches")
    private Integer watches;
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

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @JsonProperty("links")
    public Links__1 getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links__1 links) {
        this.links = links;
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
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("reporter")
    public Reporter getReporter() {
        return reporter;
    }

    @JsonProperty("reporter")
    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("assignee")
    public Object getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(Object assignee) {
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

    @JsonProperty("edited_on")
    public Object getEditedOn() {
        return editedOn;
    }

    @JsonProperty("edited_on")
    public void setEditedOn(Object editedOn) {
        this.editedOn = editedOn;
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

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("milestone")
    public Milestone getMilestone() {
        return milestone;
    }

    @JsonProperty("milestone")
    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    @JsonProperty("component")
    public Component getComponent() {
        return component;
    }

    @JsonProperty("component")
    public void setComponent(Component component) {
        this.component = component;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonProperty("votes")
    public Integer getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @JsonProperty("watches")
    public Integer getWatches() {
        return watches;
    }

    @JsonProperty("watches")
    public void setWatches(Integer watches) {
        this.watches = watches;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
