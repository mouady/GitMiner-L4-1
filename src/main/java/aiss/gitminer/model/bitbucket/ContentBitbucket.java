
package aiss.gitminer.model.bitbucket;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "raw",
    "markup",
    "html"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentBitbucket {

    @JsonProperty("raw")
    private String raw;


    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
    }

}
