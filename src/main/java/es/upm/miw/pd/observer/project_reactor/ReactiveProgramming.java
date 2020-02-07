package es.upm.miw.pd.observer.project_reactor;

import org.apache.logging.log4j.LogManager;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveProgramming {

    public Mono<Void> monoVoidEmpty() {
        return Mono.empty();
    }

    public Mono<String> monoStringEmpty() {
        return Mono.empty();
    }

    public Mono<String> monoOne() {
        return Mono.just("one");
    }

    public Mono<String> monoError() {
        return Mono.error(new RuntimeException("mono-error"));
    }

    public Mono<String> changeFromMono01ToMonoError1(Mono<String> mono) {
        return mono.switchIfEmpty(Mono.error(new RuntimeException("mono-error")));
    }

    public Mono<Void> changeFromMono01ToMono0Error(Mono<String> mono) {
        return mono.handle((item, sink) -> sink.error(new RuntimeException("mono-error")));
    }

    public Mono<String> monoDelay() {
        return Mono.delay(Duration.ofSeconds(1)).map(value -> "One");
    }

    public Mono<Void> emptySynchronize(Mono<?>... monoList) {
        return Mono.when(monoList);
    }

    public Mono<String> synchronizeWithZip(Mono<String> mono, Mono<String> event) {
        return mono.zipWith(event, (p1, p2) -> p1);
    }

    public Flux<String> synchronizeWithEvent(Mono<String> mono, Mono<String> event) {
        return mono.mergeWith(event);
    }

    public Flux<String> concatEventWithMono(Mono<String> event, Mono<String> mono) {
        return event.concatWith(mono);
    }

    public Flux<String> fluxDemo() {
        return Flux.interval(Duration.ofMillis(150)).map(value -> "A" + value).take(8);
    }

    public Flux<String> fluxLimitByFlow() {
        return Flux.interval(Duration.ofMillis(400)).map(value -> "B" + value).take(3);
    }

    public Flux<String> fluxLimitByTime() {
        return this.fluxDemo().take(Duration.ofSeconds(1));
    }

    public Flux<String> fluxesConcat() {
        return this.fluxDemo().concatWith(this.fluxLimitByFlow()).take(10);
    }

    public Flux<String> fluxesMerge() {
        return this.fluxDemo().mergeWith(this.fluxLimitByFlow()).take(10);
    }

    public Mono<Void> fluxesSync() {
        Flux<String> sequence1 = this.fluxLimitByFlow();
        Flux<String> sequence2 = this.fluxLimitByTime();
        Flux<String> sequence3 = this.fluxDemo();
        sequence1.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        sequence2.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        sequence2.subscribe(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
        return Mono.when(sequence1, sequence2, sequence3);
    }

}
