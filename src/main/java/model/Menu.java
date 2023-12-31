package model;

import bot.keyboard.KeyboardAbstract;
import bot.keyboard.SelectDayKeyboard;
import bot.keyboard.SelectMonthKeyboard;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Data
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
        return payloadToMethodMap;
    }
}
