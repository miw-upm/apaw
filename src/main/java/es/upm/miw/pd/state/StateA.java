package es.upm.miw.pd.state;


public class StateA extends State {

    @Override
    public void action1(Context context) {
        context.setState(new StateB());
        System.out.println("Se ejecuta action1 de estado A");
    }

    @Override
    public void action2(Context context) {
        System.out.println("Se ejecuta action2 de estado A");
    }

    @Override
    public String toString() {
        return "Estado A";
    }

}
