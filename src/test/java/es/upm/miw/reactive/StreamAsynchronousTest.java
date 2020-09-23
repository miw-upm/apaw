package es.upm.miw.reactive;

import es.upm.miw.rective.StreamAsynchronous;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

class StreamAsynchronousTest {

    @Test
    void testStringNumberStream() {
        LogManager.getLogger(this.getClass()).info("Before subscribe...");
        new StreamAsynchronous().stringNumberStream().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg), //onNext
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()), //onError
                () -> LogManager.getLogger(this.getClass()).info("Completed") //onComplete
        );
        LogManager.getLogger(this.getClass()).info("... After subscribe");
        Mono.delay(Duration.ofSeconds(2)).block(); // two seconds active wait
    }

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
