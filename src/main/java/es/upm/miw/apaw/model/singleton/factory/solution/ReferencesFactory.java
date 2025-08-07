package es.upm.miw.apaw.model.singleton.factory.solution;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class ReferencesFactory {

    @Getter
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

    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> this.reference++);
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }

}
