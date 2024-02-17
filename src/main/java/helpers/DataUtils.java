package helpers;

import bot.config.Config;

import java.io.IOException;

import static helpers.JsonUtils.getValueForKey;

public class DataUtils {
    public static String getName(String uid, Config config) {
        String request = null;
        try {
            request = ApiUtils.getRequest("/method/users.get?user_ids=" +
                    uid + "&access_token=" + config.getClientSecret() + "&v=5.199");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String name = getValueForKey("first_name", request);
        return name;
    }

    public static String getLastName(String uid, Config config) {
        String request = null;
        try {
            request = ApiUtils.getRequest("/method/users.get?user_ids=" +
                    uid + "&access_token=" + config.getClientSecret() + "&v=5.199");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String lastName = getValueForKey("last_name", request);
        return lastName;
    }
}
