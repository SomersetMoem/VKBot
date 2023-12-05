package bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import helpers.Config;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import static bot.keyboard.WelcomeKeyboard.createKeyboardWelcomeMenu;

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
        return environment.getProperty("client.secret");
    }

    @Override
    public void onMessageNew(MessageNew messageNew) {
        Message message = messageNew.getMessage();
        if (message.getText() != null) {
            User user = new User();
            user.setPeerId(message.getPeerId());
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


    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            VkBot bot = context.getBean(VkBot.class);
            bot.startPolling();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
