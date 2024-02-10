package bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import helpers.Config;
import model.Menu;
import model.MessageText;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static helpers.MessageUtils.adminButtonClick;
import static helpers.MessageUtils.userButtonClick;


@SpringBootApplication
public class VkBot extends LongPollBot {
    private final static Logger LOG = Logger.getLogger(VkBot.class);
    private final Config config;
    private final Menu menu;
    private final MessageText messageText;

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
        String textM = message.getText();
        int idM = message.getPeerId();
        LOG.info("Получено сообщение от пользователя: \n" + idM + "С текстом: " + textM);

        if (textM.contains("/admin") && isAdmin(idM)) {
            adminButtonClick(vk, message);
        } else {
            userButtonClick(vk, message);
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

    private boolean isAdmin(int peerId) {
        LOG.info("Проверяем является ли админом");
        boolean isAdmin = false;
        if (peerId != 0) {
            isAdmin = peerId == config.getPeerIdAdmin();
        }
        return isAdmin;
    }
}
