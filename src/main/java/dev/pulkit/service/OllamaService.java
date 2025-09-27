package dev.pulkit.service;

import dev.pulkit.config.OllamaConfig;
import dev.pulkit.config.PromptConfig;
import dev.pulkit.model.Message;
import dev.pulkit.model.OllamaRequestBody;
import dev.pulkit.model.OllamaResponseBody;
import dev.pulkit.model.enums.Role;
import dev.pulkit.utils.ParserUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OllamaService extends BaseRestService {

    private final OllamaConfig config;
    private final PromptConfig promptConfig;

    public OllamaService(OllamaConfig ollamaConfig, PromptConfig promptConfig) {
        this.config = ollamaConfig;
        this.promptConfig = promptConfig;
    }

    public String getWelcomeMessage() {
        return promptConfig.getWelcomeMessage();
    }

    public String getNextQuestion(List<Message> conversationHistory, String userResponse) {
        String url = config.getHost() + config.getEndpoint();
        String response = getResponse(url, getParams(), getHeaders(), getRequestBody(conversationHistory, userResponse), HttpMethod.POST);
        OllamaResponseBody responseBody = ParserUtils.convertStringToOllamaResponseBody(response);
        if (responseBody != null) {
            return responseBody.getMessage().getContent();
        }
        return null;
    }

    private OllamaRequestBody getRequestBody(List<Message> conversationHistory, String userResponse) {
        Message systemPrompt = new Message(Role.SYSTEM, promptConfig.getSystemPrompt());
        conversationHistory.add(0, systemPrompt);
        conversationHistory.add(new Message(Role.USER, userResponse));
        return new OllamaRequestBody(config.getModel(), conversationHistory, false);
    }

    private HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        return params;
    }

    private HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        return headers;
    }
}
