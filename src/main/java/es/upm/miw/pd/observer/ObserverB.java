package es.upm.miw.pd.observer;

public class ObserverB implements Observer {
    private Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
       System.out.println("Observer B: sujeto a cambiado: " + this.subject.getState());
    }
}
