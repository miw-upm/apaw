package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Lambda {
    public Consumer<String> functionConsumer() { // accept(T)
        return msg -> LogManager.getLogger(this.getClass()).info("Consumer: {}", () -> msg);
    }

    public Function<String, Integer> function() { // apply(T):R
        return Integer::parseInt;
    }

    public Predicate<String> functionPredicate() { // test(T):boolean
        return "two"::equals;
    }

    public Supplier<String> functionSupplier() { // get(): T
        return () -> {
            String prefix = "...";
            return prefix.concat("-");
        };
    }
}
