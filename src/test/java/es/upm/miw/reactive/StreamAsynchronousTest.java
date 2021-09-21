package es.upm.miw.reactive;

import es.upm.miw.rective.StreamAsynchronous;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class StreamAsynchronousTest {

    @Test
    void testStringNumberStreamVerifier() {
        StepVerifier
                .create(new StreamAsynchronous().stringNumberStream())
                .expectNext("0")
                .expectNext("1", "2", "3")
                .expectNextCount(6)
                .expectComplete()
                .verify();
    }

    @Test
    void testStringStream() {
        StepVerifier
                .create(new StreamAsynchronous().stringStream("A"))
                .expectNext("A0")
                .expectNext("A1", "A2")
                .thenCancel()
                .verify();
    }

    @Test
    void testStringStreamSingle() {
        StepVerifier
                .create(new StreamAsynchronous().stringStreamSingle())
                .expectNext("One")
                .expectComplete()
                .verify();
    }
}
