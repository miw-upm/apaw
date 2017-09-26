package es.upm.miw.pd.decorator.vehicle.solution;

public class Model extends Vehicle {

    private int price;

    private String description;

    public Model(int price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public String description() {
        return description + ":";
    }

}
