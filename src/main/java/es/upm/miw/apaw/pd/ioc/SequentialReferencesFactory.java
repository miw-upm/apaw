package es.upm.miw.apaw.pd.ioc;

import java.util.HashMap;
import java.util.Map;

public class SequentialReferencesFactory implements ReferencesFactory {
    private final Map<String, Integer> references;

    private int reference;

    public SequentialReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    @Override
    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> reference++);
    }

    @Override
    public void removeReference(String key) {
        this.references.remove(key);
    }

}
