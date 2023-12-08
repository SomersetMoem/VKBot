package bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import bot.service.WelcomeService;
import helpers.Config;
import lombok.var;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class VkBot extends LongPollBot {
    private final Config config;
    private WelcomeService welcomeMessage = new WelcomeService();
    private final static Logger LOG = Logger.getLogger(VkBot.class);

    public VkBot(Config config) {
        this.config = config;
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
        LOG.info("Получено сообщение от пользователя " + idM + "с текстом: " + "\n" + textM);

        if (messageNew.getMessage().hasText()) {
            welcomeMessage.sendWelcomeMessageAndKeyboard(vk ,message);
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
