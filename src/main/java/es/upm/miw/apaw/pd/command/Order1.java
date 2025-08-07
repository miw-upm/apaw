package es.upm.miw.apaw.pd.command;

public class Order1 implements Order {

    private final Receptor receptor;

    public Order1(Receptor receptor) {
        this.receptor = receptor;
    }

    @Override
    public String name() {
        return "OrdenConcreta1";
    }

    @Override
    public void execute() {
        this.receptor.action1();
    }

}
