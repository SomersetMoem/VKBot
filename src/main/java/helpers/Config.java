package helpers;

import bot.VkBot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Data
@Configuration
@PropertySource("classpath:vk.properties")
public class Config {
    @Value("${client.secret}")
    private String clientSecret;

    @Override
    public String toString() {
        return "Config{" +
                "clientSecret='" + clientSecret + '\'' +
                '}';
    }

    @Bean
    public VkBot vkBot(Config config) {
        return new VkBot(config);
    }
}
