package bot.commands;

import api.longpoll.bots.model.objects.basic.Message;
import bot.config.Config;
import bot.model.UsersRepository;
import org.apache.log4j.Logger;

import java.util.stream.StreamSupport;

import static helpers.DbUtils.saveUserForDb;

public class WelcomeCommands {
    private final static Logger LOG = Logger.getLogger(WelcomeCommands.class);

    public void checkUserFirstRequest(Message message, Config config, UsersRepository usersRepository) {
        LOG.info("Проверяем, что пользователь с peerID [" + message.getPeerId() + "] обращается впервые");
        Integer peerId = message.getPeerId();

        boolean userExist = StreamSupport.stream(usersRepository
                        .findAll()
                        .spliterator(), false)
                .anyMatch(users -> users.getPeer_id().equals(peerId));

        if (!userExist) {
            saveUserForDb(message, config, usersRepository);
        }
    }
}
