package bot;

import bot.config.Config;
import bot.service.VkBot;
import bot.model.DataInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            DataInitializer dataInitializer = context.getBean(DataInitializer.class);
            dataInitializer.initializeDataProcedures();
            VkBot bot = context.getBean(VkBot.class);
            bot.startPolling();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
