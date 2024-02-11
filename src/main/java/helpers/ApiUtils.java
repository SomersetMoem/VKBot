package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiUtils {

    private static String vkApi = "https://api.vk.com";
    public static String getRequest(String url) throws IOException {
        URL uri = new URL(vkApi + url);
        URLConnection conURl = uri.openConnection();
        conURl.setConnectTimeout(2000);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(conURl.getInputStream(), "UTF-8"))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
    }
}
