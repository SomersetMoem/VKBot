package bot.service;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import bot.commands.WelcomeCommands;
import bot.config.Config;
import bot.model.Menu;
import bot.model.MessageText;
import bot.model.UsersRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import static helpers.MessageUtils.adminButtonClick;
import static helpers.MessageUtils.userButtonClick;

@Component
public class VkBot extends LongPollBot {
    private final static Logger LOG = Logger.getLogger(VkBot.class);
    private final WelcomeCommands welcomeCommands = new WelcomeCommands();
    private final Config config;
    private final Menu menu;
    private final MessageText messageText;

    private final UsersRepository usersRepository;

    public VkBot(Config config, Menu menu, MessageText messageText, UsersRepository usersRepository) {
        this.config = config;
        this.menu = menu;
        this.messageText = messageText;
        this.usersRepository = usersRepository;
    }

    public UsersRepository getUserRepository() {
        return usersRepository;
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
        welcomeCommands.checkUserFirstRequest(message, config, usersRepository);

        if (textM.contains("/admin") && isAdmin(idM)) {
            adminButtonClick(vk, message);
        } else {
            userButtonClick(vk, message);
        }
    }

    private boolean isAdmin(int peerId) {
        LOG.info("Проверяем является ли админом peerId " + peerId);
        boolean isAdmin = false;
        if (peerId != 0) {
            isAdmin = peerId == config.getPeerIdAdmin();
        }
        return isAdmin;
    }

}