package es.upm.miw.pd.decorator.vehicle.solution;

public class EDS extends Extra {
    
    private static final int PRICE = 333;

    private static final String DESCRIPTION = "EDS";

    public EDS(Vehicle vehicle) {
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
