
package aiss.gitminer.model.bitbucket.esclave.links;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import aiss.gitminer.model.bitbucket.bs.Avatar__1;
import aiss.gitminer.model.bitbucket.bs.Html__3;
import aiss.gitminer.model.bitbucket.bs.Self__3;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "html",
    "avatar"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links__3 {

    @JsonProperty("self")
    private Self__3 self;
    @JsonProperty("html")
    private Html__3 html;
    @JsonProperty("avatar")
    private Avatar__1 avatar;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("self")
    public Self__3 getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self__3 self) {
        this.self = self;
    }

    @JsonProperty("html")
    public Html__3 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__3 html) {
        this.html = html;
    }

    @JsonProperty("avatar")
    public Avatar__1 getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Avatar__1 avatar) {
        this.avatar = avatar;
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
