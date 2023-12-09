package bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import bot.keyboard.KeyboardAbstract;
import helpers.Config;
import lombok.var;
import model.Menu;
import model.MessageText;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static bot.keyboard.KeyboardAbstract.isButtonPayload;
import static helpers.MessageUtils.handleButtonClick;
import static helpers.MessageUtils.sendWelcomeMessageAndKeyboard;

@Component
@SpringBootApplication
public class VkBot extends LongPollBot {
    private final Config config;
    private final Menu menu;
    private final MessageText messageText;
    private final static Logger LOG = Logger.getLogger(VkBot.class);
    private Map<String, KeyboardAbstract> payloadToMethodMap = new HashMap<>();

    public VkBot(Config config, Menu menu, MessageText messageText) {
        this.config = config;
        this.menu = menu;
        this.messageText = messageText;
    }

    @Override
    public String getAccessToken() {
        return config.getClientSecret();
    }

    @Override
    public void onMessageNew(MessageNew messageNew) {
        Message message = messageNew.getMessage();
        var textM = message.getText();
        var idM = message.getPeerId();
        LOG.info("Получено сообщение от пользователя: \n" + idM + "С текстом: " + textM);
        if (messageNew.getMessage().hasText() && !isButtonPayload(textM)) {
            sendWelcomeMessageAndKeyboard(vk, message);
        } else {
            handleButtonClick(vk, message);
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            VkBot bot = context.getBean(VkBot.class);
            bot.startPolling();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
