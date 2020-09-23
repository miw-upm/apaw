package es.upm.miw.pd.publisher;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class PublisherNews {

    private Set<Consumer<String>> consumers;

    public PublisherNews() {
        this.consumers = new HashSet<>();
    }

    public void subscribe(Consumer<String> consumer) {
        this.consumers.add(consumer);
    }

    public void unsubscribe(Consumer<String> consumer) {
        this.consumers.remove(consumer);
    }

    public void next(String msg) {
        this.consumers.forEach(consumer -> consumer.accept(msg));
    }

}
