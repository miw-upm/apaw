package es.upm.miw.reactive;

import es.upm.miw.rective.ReactiveComponent;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class ReactiveComponentTest {

    @Test
    void testEndOfChain() {
        new ReactiveComponent().endOfChain(Flux.just(3, 2, 1, 0));
    }
}
