
package aiss.gitminer.model.bitbucket.esclave.comments;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "raw",
    "markup",
    "html"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

    @JsonProperty("type")
    private String type;
    @JsonProperty("raw")
    private String raw;
    @JsonProperty("markup")
    private String markup;
    @JsonProperty("html")
    private String html;
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

    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
    }

    @JsonProperty("markup")
    public String getMarkup() {
        return markup;
    }

    @JsonProperty("markup")
    public void setMarkup(String markup) {
        this.markup = markup;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
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
