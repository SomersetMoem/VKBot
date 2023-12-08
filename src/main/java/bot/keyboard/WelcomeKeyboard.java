package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

public class WelcomeKeyboard extends KeyboardAbstract {
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

        List<List<Button>> buttonMenu = Arrays.asList(Arrays.asList(bookProcedure, checkMyProcedure),
                Arrays.asList(priceList, canselMyProcedure));

        return new Keyboard(buttonMenu).setInline(true);
    }
}
