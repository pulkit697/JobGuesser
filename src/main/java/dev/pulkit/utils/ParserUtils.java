package dev.pulkit.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObjectToString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to convert obj to string: " + e.getMessage());
            return null;
        }
    }
}
