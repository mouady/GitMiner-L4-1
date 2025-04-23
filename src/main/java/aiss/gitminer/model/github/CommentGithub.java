package aiss.gitminer.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentGithub {

    @JsonProperty("id")
    private String id;
    @JsonProperty("body")
    private String body;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("user")
    private UserGithub user;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("created_at")
    public String getCreated_at() {
        return created_at;
    }

    @JsonProperty("created_at")
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updated_at")
    public String getUpdated_at() {
        return updated_at;
    }

    @JsonProperty("updated_at")
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @JsonProperty("user")
    public UserGithub getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(UserGithub user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommentGithub.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("body");
        sb.append('=');
        sb.append(((this.body == null) ? "<null>" : this.body));
        sb.append(',');
        sb.append("created_at");
        sb.append('=');
        sb.append(((this.created_at == null) ? "<null>" : this.created_at));
        sb.append(',');
        sb.append("updated_at");
        sb.append('=');
        sb.append(((this.updated_at == null) ? "<null>" : this.updated_at));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null) ? "<null>" : this.user));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
