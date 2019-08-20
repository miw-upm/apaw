package es.upm.miw.pd.observer.project_reactor;

import java.util.HashMap;
import java.util.Map;

public class StockFactory {

    private Map<Integer, Integer> references;

    public StockFactory() {
        this.references = new HashMap<>();
    }

    public void sum(Integer key, Integer amount) {
        references.merge(key, amount, Integer::sum);
    }

    public Integer get(Integer key) {
        return references.get(key);
    }

}
