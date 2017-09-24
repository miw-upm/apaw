package es.upm.miw.pd.ioC;

import java.util.HashMap;
import java.util.Map;

public class SequentialReferencesFactory implements ReferencesFactory {
    private Map<String, Integer> references;

    private int reference;

    public SequentialReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    @Override
    public int getReference(String key) {
        Integer result = this.references.get(key);
        if (result == null) {
            this.references.put(key, this.reference);
            result = this.reference;
            reference++;
        }
        return result;
    }

    @Override
    public void removeReference(String key) {
        this.references.remove(key);
    }

}
