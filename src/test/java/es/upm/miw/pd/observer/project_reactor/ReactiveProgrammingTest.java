package es.upm.miw.pd.observer.project_reactor;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

class ReactiveProgrammingTest {
    @Test
    void testMonoEmpty() {
        new ReactiveProgramming().monoEmpty().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg), //onNext
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()), //onError
                () -> LogManager.getLogger(this.getClass()).info("Completed") //onComplete
        );
    }

    @Test
    void testMonoOne() {
        LogManager.getLogger(this.getClass()).info("Before Mono.just...");
        new ReactiveProgramming().monoOne().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg)
        );
        LogManager.getLogger(this.getClass()).info("... After Mono.just");
    }

    @Test
    void testMonoError() {
        new ReactiveProgramming().monoError().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg),
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()),
                () -> LogManager.getLogger(this.getClass()).info("Completed")
        );
    }

    @Test
    void testMonoDelayBlock() {
        LogManager.getLogger(this.getClass()).info("Before Mono.delay...");
        String msg = new ReactiveProgramming().monoDelay().block();
        LogManager.getLogger(this.getClass()).info("... After Mono.delay. msg:" + msg);
    }

    @Test
    void testMonoDelay() {
        LogManager.getLogger(this.getClass()).info("Before Mono.delay...");
        Mono<String> publisher = new ReactiveProgramming().monoDelay();
        publisher.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        LogManager.getLogger(this.getClass()).info("... After Mono.delay");
        publisher.block();
    }

    @Test
    void testMonoDelayStepVerifier() {
        StepVerifier
                .create(new ReactiveProgramming().monoDelay())
                .expectNext("One")
                .expectComplete()
                .verify();
    }

    @Test
    void testFluxDemoStepVerifier() {
        StepVerifier
                .create(new ReactiveProgramming().fluxDemo())
                .expectNext("A0", "A1", "A2")
                .expectNextMatches(name -> name.startsWith("A")) //A3
                .expectNextCount(4) //A4..7
                .expectComplete()
                .verify();
    }

    @Test
    void testFluxDemoLimitByFlow() {
        StepVerifier
                .create(new ReactiveProgramming().fluxLimitByFlow())
                .expectNext("B0", "B1", "B2")
                .expectComplete()
                .verify();
    }

    @Test
    void testFluxDelayLimitByTime() throws InterruptedException {
        StepVerifier
                .create(new ReactiveProgramming().fluxLimitByTime())
                .thenConsumeWhile(msg -> true)
                .expectComplete()
                .verify(Duration.ofSeconds(2));
    }

    @Test
    void testFluxDelayLimitByTimeBlock() {
        String last = new ReactiveProgramming().fluxLimitByTime().blockLast();
        LogManager.getLogger(this.getClass()).info("Completed, last:" + last);
    }


    @Test
    void testFluxesConcat() {
        StepVerifier
                .create(new ReactiveProgramming().fluxesConcat())
                .expectNext("A0", "A1", "A2", "A3")
                .thenConsumeWhile(msg -> true)
                .expectComplete()
                .verify();
    }

    @Test
    void testFluxesMerge() {
        StepVerifier
                .create(new ReactiveProgramming().fluxesMerge())
                .expectNext("A0", "A1", "B0", "A2")
                .thenCancel()
                .verify();
    }

}
