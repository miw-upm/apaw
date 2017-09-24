package es.upm.miw.pd.decorator.vehicle.solution;

public final class MainDecorator {
    private MainDecorator() {
    }

    public static void main(String[] args) {
        Vehicle v = new Model(1000, "base");
        Vehicle d1 = new GPS(v);
        Vehicle d2 = new MP3(d1);
        Vehicle d3 = new EDS(d2);

        System.out.println("Price: " + d3.price());
        System.out.println("Description: " + d3.description());

    }

}
