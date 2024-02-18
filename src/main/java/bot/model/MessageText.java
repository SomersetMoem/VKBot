package bot.model;

import helpers.DbUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
public class MessageText {
    public static MessageText messageText = new MessageText();
    private final static Logger LOG = Logger.getLogger(DbUtils.class);

    private String welcomeMessage = "Добро пожаловать в студию красоты SlyFox! \uD83C\uDF1F\n" +
            "Я готов помочь вам стать ещё красивее! \uD83D\uDC85\n" +
            "Пожалуйста, выберете соответствующий пункт меню!";
    private String monthSelectMessage = "Выберите месяц для записи:)";
    private String daySelectMessage = "Выберите день для записи:)";
    private String timeSelectMessage = "Выберите время для записи:)";


    public static Map<String, String> getMapMessageText() {
        Map<String, String> payloadToMethodMap = new HashMap<>();
        payloadToMethodMap.put("bookProcedure", messageText.monthSelectMessage);
        payloadToMethodMap.put("selectMonthMenu", messageText.daySelectMessage);
        payloadToMethodMap.put("selectDayMenu", messageText.timeSelectMessage);
        payloadToMethodMap.put("checkMyProcedure", "В разработке");
        payloadToMethodMap.put("priceList", dataInitPriceList());
        payloadToMethodMap.put("canselMyProcedure", "В разработке");
        return payloadToMethodMap;
    }

    public static String dataInitPriceList() {
        LOG.
    }
}
