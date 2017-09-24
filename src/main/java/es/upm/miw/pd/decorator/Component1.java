package es.upm.miw.pd.decorator;

import org.apache.logging.log4j.LogManager;

public class Component1 extends Component {

    @Override
    public void view() {
        LogManager.getLogger(this.getClass().getName()).info("Concreto");
    }
}
