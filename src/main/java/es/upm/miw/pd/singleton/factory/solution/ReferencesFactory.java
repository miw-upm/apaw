package es.upm.miw.pd.singleton.factory.solution;

import java.util.HashMap;
import java.util.Map;

public class ReferencesFactory {

    private static final ReferencesFactory factory = new ReferencesFactory();

    private Map<String, Integer> references;

    private int reference;

    private ReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    public static ReferencesFactory getFactory() {
        return factory;
    }

    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> reference++);
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }

}
