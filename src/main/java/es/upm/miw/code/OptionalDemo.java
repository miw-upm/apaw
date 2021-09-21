package es.upm.miw.code;

import java.util.Optional;

public class OptionalDemo {
    public Optional<String> readById(String id) {
        if ("0".equals(id)) {
            return Optional.empty();
        } else {
            return Optional.of("value");
        }
    }

    public String readByIdAssured(String id) {
        return this.readById(id).orElse("default");
    }

    public String readByIdAssuredWithException(String id) {
        return this.readById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
