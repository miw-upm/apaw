package es.upm.miw.apaw.pd.observer;

public class Subject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyObservers();
    }

}