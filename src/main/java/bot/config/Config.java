package bot.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Data
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"bot", "bot.model", "bot.service"})
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
