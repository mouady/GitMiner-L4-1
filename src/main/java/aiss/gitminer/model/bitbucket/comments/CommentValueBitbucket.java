
package aiss.gitminer.model.bitbucket.comments;

import aiss.gitminer.model.bitbucket.ContentBitbucket;
import aiss.gitminer.model.bitbucket.users.UserBitbucket;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "created_on",
    "updated_on",
    "content",
    "user",
    "issue",
    "links"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentValueBitbucket {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("content")
    private ContentBitbucket contentBitbucket;
    @JsonProperty("user")
    private UserBitbucket user;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    private String updatedOn;


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("updated_on")
    public String getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updated_on")
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("content")
    public ContentBitbucket getContent() {
        return contentBitbucket;
    }

    @JsonProperty("content")
    public void setContent(ContentBitbucket contentBitbucket) {
        this.contentBitbucket = contentBitbucket;
    }

    @JsonProperty("user")
    public UserBitbucket getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(UserBitbucket user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "Value{" +
                ", id=" + id +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn=" + updatedOn +
                ", content=" + contentBitbucket +
                ", user=" + user +
                '}';
    }
}
