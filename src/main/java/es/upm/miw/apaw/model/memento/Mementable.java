package es.upm.miw.apaw.model.memento;

public interface Mementable<T> {
    T createMemento();

    void restoreMemento(T memento);

}
