
package aiss.gitminer.model.bitbucket.esclave;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import aiss.gitminer.model.bitbucket.bs.*;
import aiss.gitminer.model.bitbucket.esclave.users.Author;
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

    @JsonProperty("type")
    private String type;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("date")
    private String date;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("message")
    private String message;
    @JsonProperty("summary")
    private Summary summary;
    @JsonProperty("links")
    private Links__1 links;
    @JsonProperty("parents")
    private List<Parent> parents;
    @JsonProperty("rendered")
    private Rendered rendered;
    @JsonProperty("repository")
    private Repository repository;
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
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
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
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @JsonProperty("links")
    public Links__1 getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links__1 links) {
        this.links = links;
    }

    @JsonProperty("parents")
    public List<Parent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    @JsonProperty("rendered")
    public Rendered getRendered() {
        return rendered;
    }

    @JsonProperty("rendered")
    public void setRendered(Rendered rendered) {
        this.rendered = rendered;
    }

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
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
