package bot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class User {
    private String name;
    private String familyName;
    private String phoneNumber;
    private String monthVisit;
    private String dayVisit;
    private int peerId;
}
