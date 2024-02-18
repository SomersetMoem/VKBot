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

    private final String WELCOME_MESSAGE = "Добро пожаловать в студию красоты SlyFox! \uD83C\uDF1F\n" +
            "Я готов помочь вам стать ещё красивее! \uD83D\uDC85\n" +
            "Пожалуйста, выберете соответствующий пункт меню!";
    private final String MONTH_SELECT_MESSAGE = "Выберите месяц для записи:)";
    private final String DAY_SELECT_MESSAGE = "Выберите день для записи:)";
    private final String TIME_SELECT_MESSAGE = "Выберите время для записи:)";


    public static Map<String, String> getMapMessageText() {
        Map<String, String> payloadToMethodMap = new HashMap<>();
        payloadToMethodMap.put("bookProcedure", messageText.MONTH_SELECT_MESSAGE);
        payloadToMethodMap.put("selectMonthMenu", messageText.DAY_SELECT_MESSAGE);
        payloadToMethodMap.put("selectDayMenu", messageText.TIME_SELECT_MESSAGE);
        payloadToMethodMap.put("checkMyProcedure", "В разработке");
        payloadToMethodMap.put("priceList", dataInitPriceList());
        payloadToMethodMap.put("canselMyProcedure", "В разработке");
        return payloadToMethodMap;
    }

    public static String dataInitPriceList() {
        StringBuilder priceList = new StringBuilder();
        priceList.append("🌟 **Прайс-лист на наращивание ресниц** 🌟\n\n");
        priceList.append("1. Наращивание ресниц классика - 700 рублей\n");
        priceList.append("2. Наращивание ресниц 2D - 999 рублей\n");
        priceList.append("3. Наращивание уголков глаз - 500 рублей\n");
        return priceList.toString();
    }
}
