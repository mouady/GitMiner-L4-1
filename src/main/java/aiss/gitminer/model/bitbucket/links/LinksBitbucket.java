
package aiss.gitminer.model.bitbucket.links;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "avatar",
    "html"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinksBitbucket {

    @JsonProperty("self")
    private LinksSelfBitbucket linksSelfBitbucket;
    @JsonProperty("avatar")
    private LinksAvatarBitbucket linksAvatarBitbucket;
    @JsonProperty("html")
    private LinksHtmlBitbucket linksHtmlBitbucket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("self")
    public LinksSelfBitbucket getSelf() {
        return linksSelfBitbucket;
    }

    @JsonProperty("self")
    public void setSelf(LinksSelfBitbucket linksSelfBitbucket) {
        this.linksSelfBitbucket = linksSelfBitbucket;
    }

    @JsonProperty("avatar")
    public LinksAvatarBitbucket getAvatar() {
        return linksAvatarBitbucket;
    }

    @JsonProperty("avatar")
    public void setAvatar(LinksAvatarBitbucket linksAvatarBitbucket) {
        this.linksAvatarBitbucket = linksAvatarBitbucket;
    }

    @JsonProperty("html")
    public LinksHtmlBitbucket getHtml() {
        return linksHtmlBitbucket;
    }

    @JsonProperty("html")
    public void setHtml(LinksHtmlBitbucket linksHtmlBitbucket) {
        this.linksHtmlBitbucket = linksHtmlBitbucket;
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
