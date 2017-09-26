package es.upm.miw.pd.command;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    
    private Map<String, Order> orders;

    public Invoker() {
        this.orders = new HashMap<>();
    }

    public void add(Order orden) {
        this.orders.put(orden.name(), orden);
    }

    public void execute(String key) {
        this.orders.get(key).execute();
    }

    public String[] keys() {
        return this.orders.keySet().toArray(new String[0]);
    }
}
