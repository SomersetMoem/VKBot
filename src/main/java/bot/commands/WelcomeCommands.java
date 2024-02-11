package bot.commands;

import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.User;
import bot.config.Config;
import bot.model.UserRepository;
import bot.model.Users;
import bot.service.VkBot;
import helpers.DataUtils;
import helpers.MessageUtils;
import org.apache.log4j.Logger;

public class WelcomeCommands {
    private final static Logger LOG = Logger.getLogger(WelcomeCommands.class);

    public void checkUserFirstRequest(Message message, Config config, UserRepository userRepository) {
        LOG.info("Проверяем, что пользователь с peerID [" + message.getPeerId() + "] обращается впервые" );
        if ()

    }
}
