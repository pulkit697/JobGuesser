import dev.pulkit.client.HttpClient;
import dev.pulkit.model.Message;
import dev.pulkit.model.enums.Role;
import dev.pulkit.utils.ParserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiTester {

    public static void main(String[] args) {
        SelfApiService selfApiService = new SelfApiService();

        String message = selfApiService.getHealth();
        System.out.println("Health Check: " + message);

        List<Message> conversationHistory = new ArrayList<>();
        message = selfApiService.getWelcomeMessage();
        System.out.println("Assistant: " + message);
        conversationHistory.add(new Message(Role.ASSISTANT, message));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("User: ");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("quit")) {
                break;
            }
            message = selfApiService.getNextQuestion(conversationHistory, userInput);
            conversationHistory.add(new Message(Role.USER, userInput));
            conversationHistory.add(new Message(Role.ASSISTANT, message));
            System.out.println("Assistant: " + message);
        }
    }
}
