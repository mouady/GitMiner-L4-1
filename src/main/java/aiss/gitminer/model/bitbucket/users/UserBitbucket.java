
package aiss.gitminer.model.bitbucket.users;

import aiss.gitminer.model.bitbucket.links.LinksBitbucket;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "display_name",
    "links",
    "created_on",
    "type",
    "uuid",
    "has_2fa_enabled",
    "username",
    "is_staff",
    "account_id",
    "nickname",
    "account_status",
    "location"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBitbucket {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("links")
    private LinksBitbucket linksBitbucket;


    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("links")
    public LinksBitbucket getLinks() {
        return linksBitbucket;
    }

    @JsonProperty("links")
    public void setLinks(LinksBitbucket linksBitbucket) {
        this.linksBitbucket = linksBitbucket;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
