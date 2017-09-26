package es.upm.miw.pd.decorator.vehicle.solution;

public class GPS extends Extra {

    private static final int PRICE = 123;

    private static final String DESCRIPTION = "GPS";

    public GPS(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public int price() {
        return this.getVehicle().price() + PRICE;
    }

    @Override
    public String description() {
        return this.getVehicle().description() + " " + DESCRIPTION;
    }

}
