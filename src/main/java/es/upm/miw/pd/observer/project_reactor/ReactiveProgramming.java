package es.upm.miw.pd.observer.project_reactor;

import org.apache.logging.log4j.LogManager;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveProgramming {

    public Mono<Void> monoEmpty() {
        return Mono.empty();
    }

    public Mono<String> monoOne() {
        return Mono.just("one");
    }

    public Mono<String> monoError() {
        return Mono.error(new RuntimeException("mono-error"));
    }

    public Mono<String> monoDelay() {
        return Mono.delay(Duration.ofSeconds(1)).map(value -> "One");
    }

    public Flux<String> fluxDemo() {
        return Flux.interval(Duration.ofMillis(200)).map(value -> "A" + value).take(8);
    }

    public Flux<String> fluxLimitByFlow() {
        return Flux.interval(Duration.ofMillis(400)).map(value -> "B" + value).take(3);
    }

    public Flux<String> fluxLimitByTime() {
        return this.fluxDemo().take(Duration.ofSeconds(2));
    }


    public Flux<String> fluxesMerge() {
        return this.fluxDemo().mergeWith(this.fluxLimitByFlow()).take(10);
    }

    public Mono<Void> fluxesSync() {
        Flux<String> sequence1 = this.fluxLimitByFlow();
        Flux<String> sequence2 = this.fluxLimitByTime();
        sequence1.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        sequence2.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        return Mono.when(sequence1, sequence2);
    }

}
