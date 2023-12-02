package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static helpers.DateUtils.getCountDayOfMonth;

public class SelectDayKeyboard {
    private static final Button.Color PRIMARY_COLOR = Button.Color.PRIMARY;

    public Keyboard createKeyBoardSelectDay() {
        int countDayOfMonth = getCountDayOfMonth();
        JsonObject payload = new JsonObject();//Сделать по анлогии с селект монтс кейборд

        List<Button> buttons = IntStream
        for (int i = 0; i < countDayOfMonth; i++) {
            payload.addProperty("selectDayMenu", String.valueOf(countDayOfMonth));
            Button buttonDay = new TextButton(Button.Color.PRIMARY,
                    new TextButton.Action(String.valueOf(countDayOfMonth), payload));
            List<List<Button>> buttonMenu = Arrays.asList(Arrays.asList(buttonDay));
        }
        return new Keyboard(buttonMenu).setOneTime(true);
    }

}
