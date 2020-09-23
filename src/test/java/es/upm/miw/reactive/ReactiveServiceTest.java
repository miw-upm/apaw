package es.upm.miw.reactive;

import es.upm.miw.rective.ReactiveService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.stream.Stream;

class ReactiveServiceTest {

    @Test
    void testConvertToInteger() {
        StepVerifier
                .create(new ReactiveService().convertToInteger(Flux.just("2", "4", "9")))
                .expectNext(2)
                .expectNext(4, 9)
                .expectComplete()
                .verify();
    }

    @Test
    void testTransformToNumber() {
        StepVerifier
                .create(new ReactiveService().transformToNumber(Mono.just("One")))
                .expectNext(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testTransformToNumberEmpty() {
        StepVerifier
                .create(new ReactiveService().transformToNumber(Mono.just("kk")))
                .expectNext(-1)
                .expectComplete()
                .verify();
    }

    @Test
    void testSum() {
        StepVerifier
                .create(new ReactiveService().sum(Flux.just(1, 2, 3)))
                .expectNext(6)
                .expectComplete()
                .verify();
    }

    @Test
    void testSumEmpty() {
        StepVerifier
                .create(new ReactiveService().sum(Flux.empty()))
                .expectNext(0)
                .expectComplete()
                .verify();
    }

    @Test
    void testSumError() {
        StepVerifier
                .create(new ReactiveService().sum(Flux.error(new RuntimeException("mono-error"))))
                .expectError()
                .verify();
    }

    @Test
    void testFromStream() {
        StepVerifier
                .create(new ReactiveService().fromStream(Stream.of("0", "1")))
                .expectNext("0", "1")
                .expectComplete()
                .verify();
    }

    @Test
    void testFilter() {
        StepVerifier
                .create(new ReactiveService().filter(Flux.just("0", "1", "2"), "1"))
                .expectNext("1")
                .expectComplete()
                .verify();
    }

    @Test
    void testConcat() {
        StepVerifier
                .create(new ReactiveService().concat(Flux.just("0", "1"), Flux.just("2", "3")))
                .expectNext("0")
                .expectNextCount(2)
                .expectNext("3")
                .expectComplete()
                .verify();
    }

    @Test
    void testMerge() {
        StepVerifier
                .create(new ReactiveService().merge(Flux.just("0", "1"), Flux.just("2", "3")))
                .expectNextMatches(item -> "0".equals(item) || "2".equals(item))
                .expectNext("3")
                .expectComplete()
                .verify();
    }

    @Test
    void testErrorIfEmpty() {
        StepVerifier
                .create(new ReactiveService().errorIfEmpty(Flux.empty()))
                .expectError()
                .verify();
    }

    @Test
    void testZeroIfEmpty() {
        StepVerifier
                .create(new ReactiveService().zeroIfEmpty(Flux.empty()))
                .expectNext("0")
                .expectComplete()
                .verify();
    }

}
