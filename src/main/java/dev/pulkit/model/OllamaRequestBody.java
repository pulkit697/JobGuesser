package dev.pulkit.model;

import org.springframework.lang.NonNull;

import java.util.List;

public class OllamaRequestBody {
    private String model;
    private List<Message> messages;
    private boolean stream;

    public OllamaRequestBody() {
    }

    public OllamaRequestBody(@NonNull String model, @NonNull List<Message> messages, boolean stream) {
        this.model = model;
        this.messages = messages;
        this.stream = stream;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
