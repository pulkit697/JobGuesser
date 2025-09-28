import dev.pulkit.model.Message;
import dev.pulkit.model.enums.Role;
import dev.pulkit.service.BaseRestService;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.List;

public class SelfApiService extends BaseRestService {

    public SelfApiService() {}

    public String getNextQuestion(List<Message> conversationHistory, String userResponse) {
        HashMap<String, String> params = new HashMap<>();
        params.put("userResponse", userResponse);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return getResponse("http://localhost:8080/nextQuestion", params, headers, conversationHistory, HttpMethod.POST);
    }

    public String getWelcomeMessage() {
        return getResponse("http://localhost:8080/welcome", null, null, null, HttpMethod.GET);
    }

    public String getHealth() {
        return getResponse("http://localhost:8080/health", null, null, null, HttpMethod.GET);
    }
}
