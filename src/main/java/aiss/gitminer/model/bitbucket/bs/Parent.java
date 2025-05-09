
package aiss.gitminer.model.bitbucket.bs;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import aiss.gitminer.model.bitbucket.esclave.links.Links__2;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hash",
    "links",
    "type"
})
@Generated("jsonschema2pojo")
public class Parent {

    @JsonProperty("hash")
    private String hash;
    @JsonProperty("links")
    private Links__2 links;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("links")
    public Links__2 getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links__2 links) {
        this.links = links;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
