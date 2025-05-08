
package aiss.gitminer.model.bitbucket;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "html",
    "diff",
    "approve",
    "comments",
    "statuses",
    "patch"
})
@Generated("jsonschema2pojo")
public class Links__1 {

    @JsonProperty("self")
    private Self__1 self;
    @JsonProperty("html")
    private Html__1 html;
    @JsonProperty("diff")
    private Diff diff;
    @JsonProperty("approve")
    private Approve approve;
    @JsonProperty("comments")
    private Comments comments;
    @JsonProperty("statuses")
    private Statuses statuses;
    @JsonProperty("patch")
    private Patch patch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("self")
    public Self__1 getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self__1 self) {
        this.self = self;
    }

    @JsonProperty("html")
    public Html__1 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__1 html) {
        this.html = html;
    }

    @JsonProperty("diff")
    public Diff getDiff() {
        return diff;
    }

    @JsonProperty("diff")
    public void setDiff(Diff diff) {
        this.diff = diff;
    }

    @JsonProperty("approve")
    public Approve getApprove() {
        return approve;
    }

    @JsonProperty("approve")
    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    @JsonProperty("comments")
    public Comments getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @JsonProperty("statuses")
    public Statuses getStatuses() {
        return statuses;
    }

    @JsonProperty("statuses")
    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

    @JsonProperty("patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
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
