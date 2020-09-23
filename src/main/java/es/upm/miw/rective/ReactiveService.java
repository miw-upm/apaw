package es.upm.miw.rective;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReactiveService {

    public Flux<Integer> convertToInteger(Flux<String> flux) {
        return flux.map(Integer::valueOf);
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

    public Flux<String> filter(Flux<String> flux, String... values) {
        return flux.filter(Arrays.asList(values)::contains);
    }

    public Flux<String> concat(Flux<String> flux1, Flux<String> flux2) {
        return Flux.concat(flux1, flux2);
    }

    public Flux<String> merge(Flux<String> flux1, Flux<String> flux2) {
        return Flux.merge(flux1, flux2);
    }

    public Flux<String> errorIfEmpty(Flux<String> flux) {
        return flux.switchIfEmpty(Flux.error(new RuntimeException("empty")));
    }

    public Flux<String> zeroIfEmpty(Flux<String> flux) {
        return flux.defaultIfEmpty("0");
    }

    public Mono<Integer> sum(Flux<Integer> flux) {
        return flux.reduce(0, Integer::sum);
    }

}
