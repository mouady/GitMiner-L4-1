
package aiss.gitminer.model.bitbucket.esclave.comments;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "values",
    "pagelen",
    "size",
    "page"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentBitbucket {

    @JsonProperty("values")
    private List<CommentValue> values;
    @JsonProperty("pagelen")
    private Integer pagelen;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("page")
    private Integer page;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("values")
    public List<CommentValue> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<CommentValue> values) {
        this.values = values;
    }

    @JsonProperty("pagelen")
    public Integer getPagelen() {
        return pagelen;
    }

    @JsonProperty("pagelen")
    public void setPagelen(Integer pagelen) {
        this.pagelen = pagelen;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CommentBitbucket{" +
                "values=" + values +
                ", pagelen=" + pagelen +
                ", size=" + size +
                ", page=" + page +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
