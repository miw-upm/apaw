package es.upm.miw.apaw.pd.decorator.vehicle.solution;

public class Model extends Vehicle {

    private final int price;

    private final String description;

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
