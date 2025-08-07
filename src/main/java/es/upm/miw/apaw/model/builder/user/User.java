package es.upm.miw.apaw.model.builder.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    private String nick;
    private String name;
    private String familyName;
    private Integer age;
    private Integer phone;
    private String profession;
    private List<String> tags;

    public User(UUID id, String nick) {
        this(id, nick, null, null, null, null, null, null);
    }

    public User(UUID id, String nick, String name) {
        this(id, nick, name, null, null, null, null, null);
    }

    public User(UUID id, String nick, String name, String familyName, int phone) {
        this(id, nick, name, familyName, null, phone, null, null);
    }

}
