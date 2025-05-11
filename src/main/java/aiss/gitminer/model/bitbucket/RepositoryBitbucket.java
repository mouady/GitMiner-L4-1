
package aiss.gitminer.model.bitbucket;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "full_name",
    "links",
    "name",
    "slug",
    "description",
    "scm",
    "website",
    "owner",
    "workspace",
    "is_private",
    "project",
    "fork_policy",
    "created_on",
    "updated_on",
    "size",
    "language",
    "uuid",
    "mainbranch",
    "override_settings",
    "parent",
    "enforced_signed_commits",
    "has_issues",
    "has_wiki"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryBitbucket {

    @JsonProperty("name")
    private String name;
    @JsonProperty("website")
    private String website;
    @JsonProperty("uuid")
    private String uuid;


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
