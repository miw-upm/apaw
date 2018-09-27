package es.upm.miw.pd.observer.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable {

    private List<Consumer<String>> consumers;

    public Observable() {
        this.consumers = new ArrayList<>();
    }

    public Consumer<String> subscribe(Consumer<String> consumer) {
        this.consumers.add(consumer);
        return consumer;
    }

    public void unsubscribe(Consumer<String> consumer) {
        this.consumers.remove(consumer);
    }

    public void accept(String data) {
        this.consumers.forEach(c -> c.accept(data));
    }
}
