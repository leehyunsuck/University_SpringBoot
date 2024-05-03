package webjava.servlet.basic;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class SlackNotifier2 {
    private static final String SLACK_WEBHOOK_URL = "https://hooks.slack.com/services/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";

    public static void send(String errorMsg) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String reg_Error = errorMsg.replace("\"", "\\\"");
        String slackMessage = "{\"text\": \"" + reg_Error + "\"}";

        HttpEntity<String> request = new HttpEntity<>(slackMessage, headers);

        restTemplate.postForObject(SLACK_WEBHOOK_URL, request, String.class);
    }
}
