package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static helpers.DateUtils.getNameMonthOfNumber;

public class SelectMonthKeyboard extends KeyboardAbstract {
    private final Logger LOG = Logger.getLogger(SelectMonthKeyboard.class);
    @Override
    public Keyboard generateKeyboard() {
        LOG.info("Создаем клавиатуру для выбора месяца");
        JsonObject payload = new JsonObject();
        List<Button> buttons = IntStream.range(1, 13)
                .mapToObj(i -> {
                    payload.addProperty("selectMonthMenu", String.valueOf(getNameMonthOfNumber(i)));
                    return new TextButton(PRIMARY_COLOR, new TextButton.Action(String.valueOf(i), payload));
                })
                .collect(Collectors.toList());
        List<List<Button>> buttonMenu = partitionList(buttons, 5);

        return new Keyboard(buttonMenu).setOneTime(true);
    }

    private <T> List<List<T>> partitionList(List<T> list, int size) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.groupingBy(index -> index / size))
                .values()
                .stream()
                .map(indices -> indices.stream().map(list::get).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
