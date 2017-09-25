package es.upm.miw.pd.singleton.factory;

import java.util.HashMap;
import java.util.Map;

public class ReferencesFactory {
    private Map<String, Integer> references;

    private int reference;

    public ReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> reference++);
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }

}
