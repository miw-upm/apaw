package es.upm.miw.pd.publisher;

import java.util.Set;
import java.util.function.Consumer;

public class Publisher<T> {

    private Set<Consumer<T>> consumers;

    public void subscribe(Consumer<T> consumer) {
        this.consumers.add(consumer);
    }

    public void unsubscribe(Consumer<T> consumer) {
        this.consumers.remove(consumer);
    }

    public void next(T item) {
        this.consumers.forEach(consumer -> consumer.accept(item));
    }

}
