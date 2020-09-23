package es.upm.miw.rective;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class StreamAsynchronous {

    public Flux<String> stringNumberStream() {
        return Flux.interval(Duration.ofMillis(150))
                .map(String::valueOf)
                .take(10);
    }

    public Flux<String> stringStream(String root) {
        return Flux.interval(Duration.ofMillis(150))
                .map(value -> root + value)
                .take(10);
    }

    public Mono<String> stringStreamSingle() {
        return Mono.delay(Duration.ofSeconds(1))
                .map(value -> "One");
    }

}
