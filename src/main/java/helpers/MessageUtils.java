package helpers;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.basic.Message;
import bot.keyboard.WelcomeKeyboard;
import lombok.var;
import model.Menu;
import model.MessageText;

import static helpers.JsonUtils.getKeyFromJson;
import static model.Menu.getMapSelectWelcomeMenuEngkey;
import static model.MessageText.getMapMessageText;

public class MessageUtils {
    static WelcomeKeyboard welcomeKeyboard = new WelcomeKeyboard();
    static MessageText messageText = new MessageText();
    static Menu menu = new Menu();

    public static Keyboard handleButtonClick(VkBotsMethods vk, Message message) {
        var payload = getKeyFromJson(String.valueOf(message.getPayload()));
        if (getMapSelectWelcomeMenuEngkey().containsKey(payload)) {
            var keyboardGenerator = getMapSelectWelcomeMenuEngkey().get(payload);
            var keyboard = keyboardGenerator.generateKeyboard();
            var messageText = getMapMessageText().get(payload);
            try {
                vk.messages.send()
                        .setPeerId(message.getPeerId())
                        .setMessage(messageText)
                        .setKeyboard(keyboard)
                        .execute();
            } catch (VkApiException e) {
                throw new RuntimeException(e);
            }
        } else {
            sendWelcomeMessageAndKeyboard(vk, message);
        }
        return null;
    }

    public static void sendWelcomeMessageAndKeyboard(VkBotsMethods vk, Message message) {
        try {
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage(messageText.getWelcomeMessage())
                    .setKeyboard(welcomeKeyboard.generateKeyboard())
                    .execute();
        } catch (VkApiException e) {
            throw new RuntimeException(e);
        }
    }
}
