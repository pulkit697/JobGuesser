package dev.pulkit.model.enums;

public enum Role {
    SYSTEM("system"),
    ASSISTANT("assistant"),
    USER("user"),
    TOOL("tool");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
