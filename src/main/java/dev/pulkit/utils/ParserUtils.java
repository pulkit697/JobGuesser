package dev.pulkit.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pulkit.model.OllamaResponseBody;

public class ParserUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObjectToString(Object obj) {
        try {
            if (obj == null)    return null;
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to convert obj to string: " + e.getMessage());
            return null;
        }
    }

    public static OllamaResponseBody convertStringToOllamaResponseBody(String s) {
        try {
            return objectMapper.readValue(s, OllamaResponseBody.class);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to convert string to message: " + e.getMessage());
            return null;
        }
    }
}
