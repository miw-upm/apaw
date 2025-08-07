package es.upm.miw.apaw.model.memento;

import java.util.SortedMap;
import java.util.TreeMap;

public class GestorMementos<T> {
    private final SortedMap<String, T> lista = new TreeMap<>();

    public void addMemento(String key, T memento) {
        this.lista.put(this.lista.size() + ":" + key, memento);
    }

    public T getMemento(String key) {
        return this.lista.get(key);
    }

    public String[] keys() {
        return this.lista.keySet().toArray(new String[0]);
    }
}
