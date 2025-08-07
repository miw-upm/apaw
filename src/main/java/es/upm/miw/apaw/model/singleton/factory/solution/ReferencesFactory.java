package es.upm.miw.apaw.model.singleton.factory.solution;

import java.util.HashMap;
import java.util.Map;

public class ReferencesFactory {

    private static final ReferencesFactory factory;

    static {
        factory = new ReferencesFactory();
    }

    private final Map<String, Integer> references;

    private int reference;

    private ReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    public static ReferencesFactory getFactory() {
        return factory;
    }

    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> this.reference++);
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }

}
