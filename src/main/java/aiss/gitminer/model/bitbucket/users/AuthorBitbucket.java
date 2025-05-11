
package aiss.gitminer.model.bitbucket.users;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "raw",
    "user"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorBitbucket {

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
