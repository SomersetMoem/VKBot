package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

public class WelcomeKeyboard {
    private final static String BOOK_PROCEDURE_TEXT = "Записаться на процедуру";
    private final static String CHECK_MY_PROCEDURE_TEXT = "Когда я записан?";
    private final static String PRICE_LIST_TEXT = "Какая стоимость?";
    private final static String CANSEL_MY_PROCEDURE_TEXT = "Отменить запись";
    private final static String CHECK_PROMOTIONS_TEXT = "Узнать об акции";
    private static final Button.Color POSITIVE_COLOR = Button.Color.POSITIVE;
    private static final Button.Color PRIMARY_COLOR = Button.Color.PRIMARY;
    private static final Button.Color NEGATIVE_COLOR = Button.Color.NEGATIVE;
    private static final Button.Color SECONDARY_COLOR = Button.Color.SECONDARY;
    public static Keyboard createKeyboardWelcomeMenu() {
        JsonObject payload = new JsonObject();
        payload.addProperty("selectMenu", "bookProcedure");
        Button bookProcedure = new TextButton(POSITIVE_COLOR, new TextButton.Action(BOOK_PROCEDURE_TEXT, payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkMyProcedure");
        Button checkMyProcedure = new TextButton(PRIMARY_COLOR, new TextButton.Action(CHECK_MY_PROCEDURE_TEXT, payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "priceList");
        Button priceList = new TextButton(POSITIVE_COLOR, new TextButton.Action(PRICE_LIST_TEXT, payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "canselMyProcedure");
        Button canselMyProcedure = new TextButton(NEGATIVE_COLOR, new TextButton.Action(CANSEL_MY_PROCEDURE_TEXT, payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkPromotions");
        Button checkPromotions = new TextButton(SECONDARY_COLOR, new TextButton.Action(CHECK_PROMOTIONS_TEXT, payload));

        List<List<Button>> buttonMenu = Arrays.asList(Arrays.asList(bookProcedure, checkMyProcedure, priceList, canselMyProcedure, checkPromotions),
                Arrays.asList(canselMyProcedure, checkPromotions));

        return new Keyboard(buttonMenu).setInline(true);
    }
}
