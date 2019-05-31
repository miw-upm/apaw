package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublisherTest {

    @Test
    void test() {
        Publisher publisher = new Publisher();
        Consumer<String> subscription = publisher.subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer 1: " + msg)
        );
        publisher.subscribe(s -> LogManager.getLogger(this.getClass()).info("consumer 2: " + s));

        publisher.accept("dato1");
        publisher.accept("dato2");

        publisher.unsubscribe(subscription);
        publisher.accept("dato3");
    }

    @Test
    void testAssert() {
        Publisher publisher = new Publisher();
        publisher.subscribe((String msg) -> assertEquals("test", msg));

        publisher.accept("test");
    }
}
