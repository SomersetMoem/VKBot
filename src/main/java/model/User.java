package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class User {
    private String name;
    private String familyName;
    private String phoneNumber;
    private String monthVisit;
    private String dayVisit;
    private int peerId;
}
