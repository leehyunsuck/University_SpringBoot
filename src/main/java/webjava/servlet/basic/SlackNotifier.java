package webjava.servlet.basic;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;

public class SlackNotifier {
    private static final String SLACK_WEBHOOK_URL = "https://hooks.slack.com/services/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";

    public static WebhookResponse send(String errorMsg) {
        try {
            Slack slack = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(errorMsg)
                    .build();

            return slack.send(SLACK_WEBHOOK_URL, payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*

        System.getenv("application에 작성한 환경변수");  //저 값을 return함

         */
    }
}
