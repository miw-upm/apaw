package es.upm.miw.pd.builder.user.advanced_solution;

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

    public static UserBuilders.Id builder() {
        return new Builder();
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

    public static class Builder implements UserBuilders.Id, UserBuilders.Name, UserBuilders.Nick, UserBuilders.Optionals {

        private User user;

        public Builder() {
            this.user = new User();
        }

        @Override
        public UserBuilders.Nick id(String id) {
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
                this.user.tags = new ArrayList<String>();
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
