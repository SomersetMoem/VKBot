package helpers;

import api.longpoll.bots.model.objects.basic.Message;
import bot.config.Config;
import bot.model.UsersRepository;
import bot.model.Users;

import java.sql.Timestamp;

public class DbUtils {

    public static void saveUserForDb(Message message, Config config, UsersRepository usersRepository) {
        Users users = new Users();
        users.setPeer_id(message.getPeerId());
        users.setName(DataUtils.getName(String.valueOf(message.getFromId()), config));
        users.setLast_name(DataUtils.getLastName(String.valueOf(message.getFromId()), config));
        users.setRegistered_at(new Timestamp(System.currentTimeMillis()));
        usersRepository.save(users);
    }
}
