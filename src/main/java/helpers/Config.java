package helpers;

import bot.VkBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:vk.properties")
public class Config {
    @Value("${client.secret}")
    private String clientSecret;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "Config{" +
                "clientSecret='" + clientSecret + '\'' +
                '}';
    }

    @Bean
    public VkBot vkBot(Environment environment) {
        return new VkBot(environment);
    }
}
