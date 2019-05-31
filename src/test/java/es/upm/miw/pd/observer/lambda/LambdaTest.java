package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LambdaTest {

    @Test
    void testFunctionConsumer() {
        Stream.of("one", "two", "three").forEach(new Lambda().functionConsumer());
    }

    @Test
    void testFunction() {
        List<Integer> list = Stream.of("1", "2", "3").map(new Lambda().function()).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Function: " + list);
    }

    @Test
    void testPredicate() {
        List<String> list2 = Stream.of("one", "two", "three")
                .filter(new Lambda().functionPredicate()).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Predicate: " + list2);
    }

    @Test
    void testSupplier() {
        List<String> list3 = Stream.generate(new Lambda().functionSupplier()).limit(3).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Supplier: " + list3);
    }

}
