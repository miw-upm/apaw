package es.upm.miw.webpattern.dao.entities;

public class Category {

    private int id;

    private String name;

    private String description;

    private String volatil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolatil() {
        return volatil;
    }

    public void setVolatil(String volatil) {
        this.volatil = volatil;
    }

}
