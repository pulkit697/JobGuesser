package dev.pulkit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pulkit.model.enums.Role;

public class Message {
    @JsonProperty("role")
    private Role role;

    @JsonProperty("content")
    private String content;

    public Message() {}

    public Message(Role role, String content) {
        this.role = role;
        this.content = content;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
