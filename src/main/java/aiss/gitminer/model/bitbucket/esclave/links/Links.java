
package aiss.gitminer.model.bitbucket.esclave.links;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import aiss.gitminer.model.bitbucket.bs.Avatar;
import aiss.gitminer.model.bitbucket.bs.Html;
import aiss.gitminer.model.bitbucket.bs.Self;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "avatar",
    "html"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("avatar")
    private Avatar avatar;
    @JsonProperty("html")
    private Html html;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    @JsonProperty("avatar")
    public Avatar getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("html")
    public Html getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html html) {
        this.html = html;
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
