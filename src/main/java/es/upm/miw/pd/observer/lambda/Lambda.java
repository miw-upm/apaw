package es.upm.miw.pd.observer.lambda;

import org.apache.logging.log4j.LogManager;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Lambda {
    public Consumer<String> functionConsumer() { // accept(T)
        return msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg);
    }

    public Consumer<String> functionConsumer2() { // accept(T)
        return (String msg) -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg);
    }

    public Function<String, Integer> function() { // apply(T):R
        return msg -> Integer.parseInt(msg);
    }

    public Function<String, Integer> function2() { // apply(T):R
        return msg -> {
            msg.concat("...Concat");
            return Integer.parseInt(msg);
        };
    }

    public Function<String, Integer> function3() { // apply(T):R
        return Integer::new;
    }

    public Predicate<String> functionPredicate() { // test(T):boolean
        return "two"::equals;
    }

    public Predicate<String> functionPredicate2() { // test(T):boolean
        return msg -> "two".equals(msg);
    }

    public Supplier<String> functionSupplier() { // get(): T
        return () -> {
            String prefix = "...";
            return prefix.concat("-");
        };
    }
}
