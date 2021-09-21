package es.upm.miw.rective;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReactiveService {

    public Stream<Integer> convertToInteger(Stream<String> stream) {
        return stream.map(Integer::valueOf);
    }

    public Flux<Integer> convertToInteger(Flux<String> flux) {
        return flux.map(Integer::valueOf);
    }

    public Flux<Integer> convertToIntegerFlatMap(Flux<String> flux) {
        return flux.flatMap(string -> Mono.just(Integer.valueOf(string)));
    }

    public Mono<Integer> transformToNumber(Mono<String> mono) {
        return mono.map(item -> {
            if ("One".equals(item)) {
                return 1;
            } else {
                return -1;
            }
        });
    }

    public Flux<String> fromStream(Stream<String> stream) {
        return Flux.fromStream(stream);
    }

    public Flux<String> concat(Flux<String> flux1, Flux<String> flux2) {
        return Flux.concat(flux1, flux2);
    }

    public Flux<String> merge(Flux<String> flux1, Flux<String> flux2) {
        return Flux.merge(flux1, flux2);
    }

    public Flux<String> filter(Flux<String> flux, String... values) {
        return flux.filter(Arrays.asList(values)::contains);
    }

    public Flux<Tuple2<String, Integer>> zip(Flux<String> flux1, Flux<Integer> flux2) {
        return Flux.zip(flux1, flux2);
    }

    public Flux<String> zeroIfEmpty(Flux<String> flux) {
        return flux.defaultIfEmpty("0");
    }

    public Flux<String> switchIfEmpty(Flux<String> flux) {
        return flux.switchIfEmpty(Flux.just("0", "1", "2"));
    }

    public Flux<String> errorIfEmpty(Flux<String> flux) {
        return flux.switchIfEmpty(Flux.error(new RuntimeException("empty")));
    }

    public Mono<Void> and(Mono<String> mono, Flux<Integer> flux) {
        return mono.and(flux);
    }

    public Mono<Void> when(Flux<String> flux1, Flux<Integer> flux2) {
        return Mono.when(flux1, flux2);
    }

    public Mono<Void> thenEmpty(Mono<String> mono) {
        return mono.then();
    }

    public Mono<String> thenMono(Mono<String> mono1, Mono<String> mono2) {
        return mono1.then(mono2);
    }

    public Flux<String> thenFlux(Mono<String> mono, Flux<String> flux) {
        return mono.thenMany(flux);
    }

    public Mono<Integer> sum(Flux<Integer> flux) {
        return flux.reduce(0, Integer::sum);
    }

    public Mono<User> chain(User user) {
        Mono<Void> delay = Flux.interval(Duration.ofMillis(150))
                .doOnNext(value -> System.out.println(">> delay: " + value))
                .take(5)
                .then();
        Mono<User> userMono = Mono.just("666")
                .delayElement(Duration.ofMillis(100))
                .map(mobile -> {
                    System.out.println(">> delayMobile: " + mobile);
                    user.setMobile(mobile);
                    return user;
                });
        Mono<Void> noRun = Mono.just("666").delayElement(Duration.ofMillis(100))
                .doOnNext(value -> System.out.println(">> noRun: " + value))
                .then();
        return Mono.when(delay).then(userMono)
                .doOnNext(user1 -> System.out.println(">> user1: " + user1));
    }

    public Mono<User> justOrEmpty(String mobile) {
        return Mono.justOrEmpty(mobile)
                .map(mobile2 -> {
                    User user = new User();
                    user.setMobile(mobile2);
                    return user;
                });
    }

}
