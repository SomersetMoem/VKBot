package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class WelcomeKeyboard extends KeyboardAbstract {
    private final Logger LOG = Logger.getLogger(WelcomeKeyboard.class);
    @Override
    public Keyboard generateKeyboard() {
        LOG.info("Cоздаем клавиатуру основного меню");
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

        List<List<Button>> buttonMenu = Arrays.asList(
                Arrays.asList(bookProcedure),
                Arrays.asList(checkMyProcedure),
                Arrays.asList(priceList),
                Arrays.asList(canselMyProcedure)
        );

        return new Keyboard(buttonMenu).setInline(true);
    }
}
