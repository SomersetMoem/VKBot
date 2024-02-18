package bot.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Component
@Getter
@Setter
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer peer_id;
    private String name;
    private String last_name;
    private Timestamp registered_at;
}