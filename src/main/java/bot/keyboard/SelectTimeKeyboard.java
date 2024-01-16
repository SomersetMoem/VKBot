package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class SelectTimeKeyboard extends KeyboardAbstract {

    private final Logger LOG = Logger.getLogger(SelectTimeKeyboard.class);

    @Override
    public Keyboard generateKeyboard() {
        LOG.info("Создаем клавиатуру для выбора время записи");

        JsonObject payload = new JsonObject();
        payload.addProperty("selectTimeKeyboard", "time");
        Button time1 = new TextButton(POSITIVE_COLOR, new TextButton.Action("14:00", payload));

        payload.addProperty("selectTimeKeyboard", "time");
        Button time2 = new TextButton(POSITIVE_COLOR, new TextButton.Action("15:00", payload));

        List<List<Button>> buttonMenu = Arrays.asList(
                Arrays.asList(time1, time2));

        return new Keyboard(buttonMenu).setInline(true);
    }
}
