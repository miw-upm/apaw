package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ObservableTest {

    @Test
    void test() {
        Observable observable = new Observable();
        Consumer<String> subscription = observable.subscribe(s -> LogManager.getLogger(this.getClass()).info("Funciona!!! " + s));
        observable.accept("dato1");
        observable.accept("dato2");
        observable.unsubscribe(subscription);
        observable.accept("dato3");
    }
}
