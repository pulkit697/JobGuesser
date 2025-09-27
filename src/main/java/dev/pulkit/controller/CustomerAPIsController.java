package dev.pulkit.controller;

import dev.pulkit.model.Message;
import dev.pulkit.service.OllamaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerAPIsController {

    private final OllamaService ollamaService;

    public CustomerAPIsController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Health Status Ok";
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> uploadQueryAnswers() {
        return new ResponseEntity<>(ollamaService.getWelcomeMessage(), HttpStatus.OK);
    }

    @PostMapping("/nextQuestion")
    public ResponseEntity<String> getNextQuestion(
            @RequestBody List<Message> conversationHistory,
            @RequestParam String userResponse
            ) {
        return new ResponseEntity<>(ollamaService.getNextQuestion(conversationHistory, userResponse), HttpStatus.OK);
    }
}
