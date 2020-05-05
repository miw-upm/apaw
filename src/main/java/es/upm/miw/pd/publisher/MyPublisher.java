package es.upm.miw.pd.publisher;

import java.util.function.Consumer;

public class MyPublisher {

    private Publisher<String> news;

    public void subscribe(Consumer<String> client) {
        this.news.subscribe(client);
    }

    public void unsubscribe(Consumer<String> client) {
        this.news.unsubscribe(client);
    }

    public void publish(String news) {
        this.news.next(news);
    }
}
