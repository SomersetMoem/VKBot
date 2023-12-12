package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Data
public class MessageText {
    static MessageText messageText = new MessageText();

    private String welcomeMessage = "Добро пожаловать в студию красоты SlyFox! \uD83C\uDF1F\n" +
            "Я готов помочь вам стать ещё красивее! \uD83D\uDC85\n" +
            "Пожалуйста, выберете соответствующий пункт меню!";

    private String daySelectMessage = "Выберите день для записи:)";

    private String monthSelectMessage = "Выберите месяц для записи:)";


    public static Map<String, String> getMapMessageText() {
        Map<String, String> payloadToMethodMap = new HashMap<>();
        payloadToMethodMap.put("bookProcedure", messageText.monthSelectMessage);
        payloadToMethodMap.put("selectMonthMenu", messageText.daySelectMessage);
        payloadToMethodMap.put("checkMyProcedure", "В разработке");
        payloadToMethodMap.put("priceList", "В разработке");
        payloadToMethodMap.put("canselMyProcedure", "В разработке");
        return payloadToMethodMap;
    }
}
