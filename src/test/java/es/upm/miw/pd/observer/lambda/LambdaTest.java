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
        Stream.of("one", "two", "three").forEach(msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg));
    }

    @Test
    void testFunction() {
        List<Integer> list1 = Stream.of("1", "2", "3").map(new Lambda().function()).collect(Collectors.toList());
        List<Integer> list2 = Stream.of("1", "2", "3").map(Integer::new).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Function: " + list1 + ", " + list2);
    }

    @Test
    void testPredicate() {
        List<String> list1 = Stream.of("one", "two", "three")
                .filter(new Lambda().functionPredicate()).collect(Collectors.toList());
        List<String> list2 = Stream.of("one", "two", "three")
                .filter("two"::equals).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Predicate: " + list1 + ", " + list2);
    }

    @Test
    void testSupplier() {
        List<String> list1 = Stream.generate(new Lambda().functionSupplier()).limit(3).collect(Collectors.toList());
        List<String> list2 = Stream.generate(() -> {
            String prefix = "...";
            return prefix.concat("-");
        }).limit(3).collect(Collectors.toList());
        LogManager.getLogger(this.getClass()).info("Supplier: " + list1 + ", " + list2);
    }
}
