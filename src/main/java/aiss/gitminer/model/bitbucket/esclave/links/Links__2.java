
package aiss.gitminer.model.bitbucket.esclave.links;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import aiss.gitminer.model.bitbucket.bs.Html__2;
import aiss.gitminer.model.bitbucket.bs.Self__2;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "html"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links__2 {

    @JsonProperty("self")
    private Self__2 self;
    @JsonProperty("html")
    private Html__2 html;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("self")
    public Self__2 getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self__2 self) {
        this.self = self;
    }

    @JsonProperty("html")
    public Html__2 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__2 html) {
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
