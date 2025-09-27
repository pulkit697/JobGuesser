package dev.pulkit.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    SYSTEM("system"),
    ASSISTANT("assistant"),
    USER("user"),
    TOOL("tool");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public Role fromString(String s) {
        if (s == null)  return null;
        for (Role role: Role.values()) {
            if (role.value.equalsIgnoreCase(s)) {
                return role;
            }
        }
        return ASSISTANT;
    }
}
