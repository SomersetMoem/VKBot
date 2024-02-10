package bot;

import bot.model.UserRepository;
import bot.service.VkBot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static bot.model.MessageText.messageText;
import static helpers.MessageUtils.menu;

@Getter
@Setter
@Data
@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Value("${client.secret}")
    private String clientSecret;

    @Value("${peer.id.admin}")
    private int peerIdAdmin;

    @Override
    public String toString() {
        return "Config{" +
                "clientSecret='" + clientSecret + '\'' +
                '}';
    }
}
