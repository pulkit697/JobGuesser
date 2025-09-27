package dev.pulkit.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    public static String execute(String _url, HashMap<String, String> params, HashMap<String, String> headers, String requestBody, String httpMethod) throws IOException {
        URL url = buildUrl(_url, params);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(httpMethod);
        // add headers
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> header: headers.entrySet()) {
                httpURLConnection.addRequestProperty(header.getKey(), header.getValue());
            }
        }
        // add request body
        if (requestBody != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            osw.write(requestBody);
            osw.flush();
            osw.close();
            os.close();
        }

        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("response code: " + responseCode);
        String response = null;
        if (responseCode<300) {
            InputStream is = httpURLConnection.getInputStream();
            response = new String(is.readAllBytes());
        }
        System.out.println("Response: " + response);
        httpURLConnection.disconnect();
        return response;
    }

    private static URL buildUrl(String endpoint, HashMap<String, String> params) throws MalformedURLException {
        StringBuilder url = new StringBuilder(endpoint);
        if (params != null && !params.isEmpty()) {
            url.append("?");
            for (Map.Entry<String, String> param: params.entrySet()) {
                url.append(param.getKey()).append("=").append(param.getValue()).append("&");
            }
        }
        if (url.charAt(url.length()-1) == '&') {
            url.deleteCharAt(url.length()-1);
        }
        return new URL(url.toString());
    }
}
