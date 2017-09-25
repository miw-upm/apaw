package es.upm.miw.pd.state;

import org.apache.logging.log4j.LogManager;

public class StateA extends State {

    @Override
    public void action1(Context context) {
        context.setState(new StateB());
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action1 de estado A");
    }

    @Override
    public void action2(Context context) {
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action2 de estado A");
    }

    @Override
    public String toString() {
        return "Estado A";
    }

}
