package es.upm.miw.pd.memento;

public interface Mementable<T> {
    T createMemento();

    void restoreMemento(T memento);

}
