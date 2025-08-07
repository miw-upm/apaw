package es.upm.miw.apaw.pd.decorator.vehicle.solution;

public abstract class Extra extends Vehicle {

    private final Vehicle vehicle;

    public Extra(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }

}
