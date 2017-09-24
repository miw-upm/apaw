package es.upm.miw.pd.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private final Map<String, FlyweightConcrete> map = new HashMap<String, FlyweightConcrete>();

    public FlyweightConcrete get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            // Construcción perezosa
            FlyweightConcrete pl = new FlyweightConcrete(key);
            map.put(key, pl);
            return pl;
        }
    }
}
