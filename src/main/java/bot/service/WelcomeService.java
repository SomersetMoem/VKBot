package bot.service;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.objects.basic.Message;
import bot.VkBot;
import helpers.Config;
import org.springframework.stereotype.Service;

import static bot.keyboard.WelcomeKeyboard.createKeyboardWelcomeMenu;

@Service
public class WelcomeService {
    public void sendWelcomeMessageAndKeyboard(VkBotsMethods vk, Message message) {
        String defaultMessage = "Добро пожаловать в студию красоты SlyFox! 🌟\n" +
                "Я готов помочь вам стать ещё красивее! 💅\n" +
                "Пожалуйста, выберете соответствующий пункт меню!";
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
