package es.upm.miw.apaw.model.builder.user.advancedsolution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    public static UserBuilders.Id builder() {
        return new Builder();
    }

    public boolean tagContains(String tag) {
        return this.tags != null && tags.contains(tag);
    }

    public static class Builder implements UserBuilders.Id, UserBuilders.Name, UserBuilders.Nick, UserBuilders.Optionals {

        private final User user;

        public Builder() {
            this.user = new User();
        }

        @Override
        public UserBuilders.Nick id(UUID id) {
            this.user.id = id;
            return this;
        }

        @Override
        public UserBuilders.Name nick(String nick) {
            this.user.nick = nick;
            return this;
        }

        @Override
        public UserBuilders.Optionals name(String name) {
            this.user.name = name;
            return this;
        }

        @Override
        public UserBuilders.Optionals familyName(String familyName) {
            this.user.familyName = familyName;
            return this;
        }

        @Override
        public UserBuilders.Optionals age(int age) {
            this.user.age = age;
            return this;
        }

        @Override
        public UserBuilders.Optionals phone(int phone) {
            this.user.phone = phone;
            return this;
        }

        @Override
        public UserBuilders.Optionals profession(String profession) {
            this.user.profession = profession;
            return this;
        }

        @Override
        public UserBuilders.Optionals tag(String tag) {
            if (this.user.tags == null) {
                this.user.tags = new ArrayList<>();
            }
            this.user.tags.add(tag);
            return this;
        }

        @Override
        public User build() {
            return this.user;
        }
    }

}
