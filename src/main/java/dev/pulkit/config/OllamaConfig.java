package dev.pulkit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ollama")
public class OllamaConfig {
    private String host;
    private String endpoint;
    private String model;
    private boolean stream;

    public OllamaConfig(){}

    public OllamaConfig(String host, String endpoint, String model, boolean stream) {
        this.host = host;
        this.endpoint = endpoint;
        this.model = model;
        this.stream = stream;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }
}
