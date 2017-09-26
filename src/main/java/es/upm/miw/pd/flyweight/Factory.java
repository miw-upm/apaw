package es.upm.miw.pd.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    
    private final Map<String, FlyweightConcrete> map = new HashMap<>();

    public FlyweightConcrete get(String key) {
        // Construcción perezosa
        return map.computeIfAbsent(key, k -> new FlyweightConcrete(k));
    }
}
