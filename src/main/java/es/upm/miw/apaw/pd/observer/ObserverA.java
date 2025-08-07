package es.upm.miw.apaw.pd.observer;

import org.apache.logging.log4j.LogManager;

public class ObserverA implements Observer {
    private final Subject subject;

    public ObserverA(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        LogManager.getLogger(this.getClass()).info("Observer A: sujeto a cambiado: " + this.subject.getState());
    }
}
