package es.upm.miw.pd.decorator.vehicle.solution;

public class MP3 extends Extra {

    private static final int PRICE = 22;

    private static final String DESCRIPTION = "MP3";

    public MP3(Vehicle vehicle) {
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
