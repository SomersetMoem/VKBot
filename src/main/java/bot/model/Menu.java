package bot.model;

import bot.keyboard.KeyboardAbstract;
import bot.keyboard.SelectDayKeyboard;
import bot.keyboard.SelectMonthKeyboard;
import bot.keyboard.SelectTimeKeyboard;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
public class Menu {
    private String bookProcedure = "Записаться на процедуру";

    private String checkMyProcedure = "Когда я записан?";

    private String priceList = "Какая стоимость?";

    private String canselMyProcedure = "Отменить запись";

    public static Map<String, KeyboardAbstract> getMapSelectWelcomeMenuEngkey() {
        Map<String, KeyboardAbstract> payloadToMethodMap = new HashMap<>();
        payloadToMethodMap.put("bookProcedure", new SelectMonthKeyboard());
        payloadToMethodMap.put("checkMyProcedure", new SelectMonthKeyboard());
        payloadToMethodMap.put("priceList", new SelectMonthKeyboard());
        payloadToMethodMap.put("canselMyProcedure", new SelectMonthKeyboard());
        payloadToMethodMap.put("selectMonthMenu", new SelectDayKeyboard());
        payloadToMethodMap.put("selectDayMenu", new SelectTimeKeyboard());
        return payloadToMethodMap;
    }
}
