package dev.pulkit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "prompt")
public class PromptConfig {
    private String systemPrompt;
    private String welcomeMessage;

    public PromptConfig() {}

    public PromptConfig(String systemPrompt, String welcomeMessage) {
        this.systemPrompt = systemPrompt;
        this.welcomeMessage = welcomeMessage;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
