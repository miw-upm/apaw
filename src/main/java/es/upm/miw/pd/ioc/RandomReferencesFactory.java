package es.upm.miw.pd.ioc;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class RandomReferencesFactory implements ReferencesFactory {

    private Map<String, Integer> references;

    private SecureRandom random;

    public RandomReferencesFactory() {
        this.references = new HashMap<>();
        random = new SecureRandom();
    }

    @Override
    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> {
            int reference = random.nextInt();
            while (references.containsValue(reference)) {
                reference++;
            }
            return reference;
        });
    }

    @Override
    public void removeReference(String key) {
        this.references.remove(key);
    }

}
