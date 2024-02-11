package helpers;

import api.longpoll.bots.model.objects.basic.Message;
import bot.config.Config;
import bot.model.UserRepository;
import bot.model.Users;

public class DbUtils {

    public void saveUserForDb(Message message, Config config, UserRepository userRepository) {
        Users users = new Users();
        users.setPeerId(message.getPeerId());
        users.setName(DataUtils.getName(String.valueOf(message.getFromId()), config));
        users.setLastName(DataUtils.getLastName(String.valueOf(message.getFromId()), config));
        userRepository.save(users);
    }
}
