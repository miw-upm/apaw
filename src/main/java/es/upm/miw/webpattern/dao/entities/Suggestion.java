package es.upm.miw.webpattern.dao.entities;

public class Suggestion {

    private String id;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SuggestionDao{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
