package dev.pulkit.service;

import dev.pulkit.client.HttpClient;
import dev.pulkit.utils.ParserUtils;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.HashMap;

public abstract class BaseRestService {

    public String getResponse(
            String url,
            HashMap<String, String> params,
            HashMap<String, String> headers,
            Object requestBody,
            HttpMethod httpMethod
    ) {
        try {
            return HttpClient.execute(
                    url,
                    params,
                    headers,
                    ParserUtils.convertObjectToString(requestBody),
                    httpMethod.toString()
            );
        } catch (IOException e) {
            System.out.println("Failed to get response: " + e.getMessage());
            return null;
        }
    }
}
