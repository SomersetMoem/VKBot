package bot.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Table(name = "Procedures")
public class Procedures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProcedure;
    private Integer price;
    private String description;
}
