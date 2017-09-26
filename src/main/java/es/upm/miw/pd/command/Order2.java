package es.upm.miw.pd.command;

public class Order2 implements Order {
    
    private Receptor receptor;

    public Order2(Receptor receptor) {
        this.receptor = receptor;
    }

    @Override
    public String name() {
        return "OrdenConcreta2";
    }

    @Override
    public void execute() {
        this.receptor.action2();
    }

}
