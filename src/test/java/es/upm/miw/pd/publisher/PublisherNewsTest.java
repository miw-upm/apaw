package es.upm.miw.pd.publisher;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class PublisherNewsTest {

    @Test
    void testSubscribe() {
        PublisherNews publisherNew = new PublisherNews();
        Consumer<String> subcriptor = System.out::println;
        publisherNew.subscribe(subcriptor);
        publisherNew.next("test1");
        publisherNew.next("test2");
        publisherNew.next("test3");
        publisherNew.unsubscribe(subcriptor);
        publisherNew.next("test4");
        publisherNew.subscribe(subcriptor);
        publisherNew.next("test5");
    }
}
