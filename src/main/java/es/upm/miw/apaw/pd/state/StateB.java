package es.upm.miw.apaw.pd.state;

import org.apache.logging.log4j.LogManager;

public class StateB extends State {

    @Override
    public void action1(Context contexto) {
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action1 de getState B");
    }

    @Override
    public void action2(Context context) {
        context.setState(new StateA());
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action2 de getState B");
    }

    @Override
    public String toString() {
        return "State B";
    }

}
