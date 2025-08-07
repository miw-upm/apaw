package es.upm.miw.apaw.model.builder.user.solution;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    private String nick;

    private String name;

    private String familyName;

    private int age;

    private int phone;

    private String profession;

    private List<String> tags;

    public User() {
        //empty
    }

    public static Builder builder(String id, String nick, String name) {
        return new Builder(id, nick, name);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public boolean tagContains(String tag) {
        return this.tags != null && tags.contains(tag);
    }

    public static class Builder {

        private final User user;

        private Builder(String id, String nick, String name) {
            this.user = new User();
            this.user.id = id;
            this.user.nick = nick;
            this.user.name = name;
        }

        public Builder name(String name) {
            this.user.name = name;
            return this;
        }

        public Builder familyName(String familyName) {
            this.user.familyName = familyName;
            return this;
        }

        public Builder age(int age) {
            this.user.age = age;
            return this;
        }

        public Builder adult() {
            return this.age(18);
        }

        public Builder phone(int phone) {
            this.user.phone = phone;
            return this;
        }

        public Builder profession(String profession) {
            this.user.profession = profession;
            return this;
        }

        public Builder tag(String tag) {
            if (this.user.tags == null) {
                this.user.tags = new ArrayList<>();
            }
            this.user.tags.add(tag);
            return this;
        }

        public User build() {
            return this.user;
        }
    }

}
