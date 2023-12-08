package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Data
@Configuration
@PropertySource("classpath:    .properties")
public class Menu {

}
