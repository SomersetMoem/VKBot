package bot.service;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import bot.Config;
import bot.model.Menu;
import bot.model.MessageText;
import bot.model.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import static helpers.MessageUtils.adminButtonClick;
import static helpers.MessageUtils.userButtonClick;

@Component
public class VkBot extends LongPollBot {
    private final static Logger LOG = Logger.getLogger(VkBot.class);
    private final Config config;
    private final Menu menu;
    private final MessageText messageText;

    private final UserRepository userRepository;

    public VkBot(Config config, Menu menu, MessageText messageText, UserRepository userRepository) {
        this.config = config;
        this.menu = menu;
        this.messageText = messageText;
        this.userRepository = userRepository;
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
        registration();
        LOG.info("Получено сообщение от пользователя: \n" + idM + "С текстом: " + textM);
        if (textM.contains("/admin") && isAdmin(idM)) {
            adminButtonClick(vk, message);
        } else {
            userButtonClick(vk, message);
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

    public void registration() {
        userRepository.findAll();
    }
}
