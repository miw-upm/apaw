package es.upm.miw.apaw.model.builder.user;

import java.util.List;

public class User {

    private final String id;

    private String nick;

    private String name;

    private String familyName;

    private int age;

    private int phone;

    private String profession;

    private List<String> tags;

    public User(String id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public User(String id, String nick, String name, String familyName, int age, int phone, String profession, List<String> tags) {
        this(id, nick);
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.phone = phone;
        this.profession = profession;
        this.tags = tags;
    }

    public User(String id, String nick, String name) {
        this(id, nick);
        this.name = name;
    }

    public User(String id, String nick, String name, String familyName, int phone) {
        this(id, nick, name, familyName, 0, phone, null, null);
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", profession='" + profession + '\'' +
                ", tags=" + tags +
                '}';
    }
}
