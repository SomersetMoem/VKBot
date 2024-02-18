package helpers;

import api.longpoll.bots.model.objects.basic.Message;
import bot.config.Config;
import bot.model.Users;
import bot.model.UsersRepository;
import org.apache.log4j.Logger;

import java.sql.Timestamp;

public class DbUtils {
    private final static Logger LOG = Logger.getLogger(DbUtils.class);

    public static void saveUserForDb(Message message, Config config, UsersRepository usersRepository) {
        Users users = new Users();
        users.setPeer_id(message.getPeerId());
        users.setName(DataUtils.getName(String.valueOf(message.getFromId()), config));
        users.setLast_name(DataUtils.getLastName(String.valueOf(message.getFromId()), config));
        users.setRegistered_at(new Timestamp(System.currentTimeMillis()));
        LOG.info("Сохраняем в БД пользователя: " + users.toString());
        usersRepository.save(users);
    }
}
