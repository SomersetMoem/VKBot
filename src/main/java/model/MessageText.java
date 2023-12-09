package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Data
@Component
@PropertySource("classpath:messageText.properties")
public class MessageText {
static MessageText messageText = new MessageText();
    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${day.select.message}")
    private String daySelectMessage;

    @Value("${month.select.message}")
    private String monthSelectMessage;

    public static Map<String, String> getMapMessageText() {
        Map<String, String> payloadToMethodMap = new HashMap<>();
        payloadToMethodMap.put("bookProcedure", messageText.getWelcomeMessage());
        payloadToMethodMap.put("checkMyProcedure", "В разработке");
        payloadToMethodMap.put("priceList", "В разработке");
        payloadToMethodMap.put("canselMyProcedure", "В разработке");
        return payloadToMethodMap;
    }
}
