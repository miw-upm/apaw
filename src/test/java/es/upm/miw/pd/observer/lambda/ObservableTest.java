package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservableTest {

    @Test
    void test() {
        Observable observable = new Observable();
        Consumer<String> subscription = observable.subscribe(
                s -> LogManager.getLogger(this.getClass()).info("Funciona!!! " + s)
        );
        observable.subscribe(s -> LogManager.getLogger(this.getClass()).info("Soy el SEGUNDO!!! " + s));
        observable.accept("dato1");
        observable.accept("dato2");
        observable.unsubscribe(subscription);
        observable.accept("dato3");
    }

    @Test
    void testAssert() {
        Observable observable = new Observable();
        observable.subscribe((String s) -> assertEquals("test", s));
        observable.accept("test");
    }
}
