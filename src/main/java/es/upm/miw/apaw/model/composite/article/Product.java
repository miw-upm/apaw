package es.upm.miw.apaw.model.composite.article;

public abstract class Product {

    private final int id;

    private String reference;

    public Product(int id, String reference) {
        this.id = id;
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", reference=" + reference + "]";
    }

}
