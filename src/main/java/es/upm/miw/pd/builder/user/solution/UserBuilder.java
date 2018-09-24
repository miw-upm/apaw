package es.upm.miw.pd.builder.user.solution;

import es.upm.miw.pd.builder.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    private static int reference = 1;

    private List<String> tags;

    private User user;

    public UserBuilder(int id, String nick) {
        this.user = new User(id, nick);
    }

    public UserBuilder() {
        this(reference, "nick" + reference);
    }

    public UserBuilder name(String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder familyName(String familyName) {
        this.user.setFamilyName(familyName);
        return this;
    }

    public UserBuilder age(int age) {
        this.user.setAge(age);
        return this;
    }

    public UserBuilder adult() {
        return this.age(18);
    }

    public UserBuilder phone(int phone) {
        this.user.setPhone(phone);
        return this;
    }

    public UserBuilder profession(String profession) {
        this.user.setProfession(profession);
        return this;
    }

    public UserBuilder tag(String tag) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
            this.user.setTags(tags);
        }
        this.tags.add(tag);
        return this;
    }

    public UserBuilder byDefault() {
        UserBuilder userBuilder = new UserBuilder();
        return userBuilder.name("name" + reference).familyName("family" + reference).adult().phone(reference)
                .tag(reference + "a").tag(reference + "b");
    }

    public User build() {
        reference++;
        return this.user;
    }

}
