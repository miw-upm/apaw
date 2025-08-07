package es.upm.miw.apaw.pd.observer;

import org.apache.logging.log4j.LogManager;

public class ObserverB implements Observer {
    private final Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        LogManager.getLogger(this.getClass()).info("Observer B: sujeto a cambiado: " + this.subject.getState());
    }
}
