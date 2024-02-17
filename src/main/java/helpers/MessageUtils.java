package helpers;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.basic.Message;
import bot.keyboard.KeyboardAbstract;
import bot.keyboard.WelcomeKeyboard;
import bot.model.MessageText;

import static bot.model.Menu.getMapSelectWelcomeMenuEngkey;
import static bot.model.MessageText.getMapMessageText;
import static helpers.JsonUtils.getKeyFromJson;
import static helpers.JsonUtils.getValueForKey;

public class MessageUtils {
    static WelcomeKeyboard welcomeKeyboard = new WelcomeKeyboard();
    static MessageText messageText = new MessageText();


    public static Keyboard userButtonClick(VkBotsMethods vk, Message message) {
        String payload = getValueForKey("name",String.valueOf(message.getPayload()));
        if (getMapSelectWelcomeMenuEngkey().containsKey(payload)) {
            KeyboardAbstract keyboardGenerator = getMapSelectWelcomeMenuEngkey().get(payload);
            Keyboard keyboard = keyboardGenerator.generateKeyboard();
            String messageText = getMapMessageText().get(payload);
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

    public static Keyboard adminButtonClick(VkBotsMethods vk, Message message) {
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
