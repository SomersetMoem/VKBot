package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static helpers.DateUtils.getCountDayOfMonth;

public class SelectDayKeyboard {
    private static final Button.Color PRIMARY_COLOR = Button.Color.PRIMARY;

    public Keyboard createKeyBoardSelectDay() {
        int countDayOfMonth = getCountDayOfMonth(1);
        JsonObject payload = new JsonObject();

        List<Button> buttons = IntStream.range(1, countDayOfMonth + 1)  // исправление: использовать countDayOfMonth + 1
                .mapToObj(i -> {
                    payload.addProperty("selectDayMenu", String.valueOf(i));  // исправление: использовать значение i
                    return new TextButton(PRIMARY_COLOR,
                            new TextButton.Action(String.valueOf(i), payload));  // исправление: закрыть блок Action
                })
                .collect(Collectors.toList());

        List<List<Button>> buttonMenu = new ArrayList<>(Collections.singletonList(buttons));
        return new Keyboard(buttonMenu).setOneTime(true);
    }
}
