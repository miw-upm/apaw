package es.upm.miw.pd.state;

import org.apache.logging.log4j.LogManager;

public class StateB extends State {

    @Override
    public void action1(Context contexto) {
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action1 de estado B");
    }

    @Override
    public void action2(Context context) {
        context.setState(new StateA());
        LogManager.getLogger(this.getClass().getName()).info("Se ejecuta action2 de estado B");
    }

    @Override
    public String toString() {
        return "Estado B";
    }

}
