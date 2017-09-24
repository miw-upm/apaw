package es.upm.miw.pd.state;

public class StateB extends State {

    @Override
    public void action1(Context contexto) {
        System.out.println("Se ejecuta action1 de estado B");
    }

    @Override
    public void action2(Context context) {
        context.setState(new StateA());
        System.out.println("Se ejecuta action2 de estado B");
    }

    @Override
    public String toString() {
        return "Estado B";
    }

}
