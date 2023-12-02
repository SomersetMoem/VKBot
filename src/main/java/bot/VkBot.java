package bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@PropertySource("classpath:vk.properties")
public class VkBot extends LongPollBot {
    Environment environment;
    @Autowired
    public VkBot(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String getAccessToken() {
        return environment.getProperty("client.Secret");
    }

    @Override
    public void onMessageNew(MessageNew messageNew) {
        Message message = messageNew.getMessage();
        if (message.getText() != null) {
            PEER_ID = message.getPeerId();
            String defaultMessage = "Добро пожаловать в студию красоты SlyFox! 🌟\n" +
                    "Я готов помочь вам стать ещё красивее! 💅\n" +
                    "Пожалуйста, выберете соотвествующий пункт меню!";
            try {
                vk.messages.send()
                        .setPeerId(message.getPeerId())
                        .setMessage(defaultMessage)
                        .setKeyboard(createKeyboardWelcomeMenu())
                        .execute();

            } catch (VkApiException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private Keyboard createKeyboardWelcomeMenu() {
        JsonObject payload = new JsonObject();
        payload.addProperty("selectMenu", "bookProcedure");
        Button bookProcedure = new TextButton(Button.Color.POSITIVE, new TextButton.Action("Записаться на процедуру", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkMyProcedure");
        Button checkMyProcedure = new TextButton(Button.Color.PRIMARY, new TextButton.Action("Когда я записан?", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "priceList");
        Button priceList = new TextButton(Button.Color.POSITIVE, new TextButton.Action("Стоимость", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "canselMyProcedure");
        Button canselMyProcedure = new TextButton(Button.Color.NEGATIVE, new TextButton.Action("Отменить запись", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkPromotions");
        Button checkPromotions = new TextButton(Button.Color.SECONDARY, new TextButton.Action("Узнать об акциях", payload));

        List<List<Button>> buttonMenu = Arrays.asList(Arrays.asList(bookProcedure, checkMyProcedure, priceList, canselMyProcedure, checkPromotions),
                Arrays.asList(canselMyProcedure, checkPromotions));

        return new Keyboard(buttonMenu).setInline(true);
    }

    public static void main(String[] args) {
        SpringApplication.run(VkBot.class, args);
    }
}
