package es.upm.miw.pd.publisher;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class PublisherNewsTest {

    @Test
    void testSubscribe() {
        PublisherNews publisherNew = new PublisherNews();
        Consumer<String> subscript = msg -> System.out.println("one: " + msg);
        publisherNew.subscribe(subscript);
        publisherNew.subscribe(msg -> System.out.println("two: " + msg));
        publisherNew.next("test1");
        publisherNew.next("test2");
        publisherNew.next("test3");
        publisherNew.unsubscribe(subscript);
        publisherNew.next("test4");
        publisherNew.subscribe(subscript);
        publisherNew.next("test5");
    }
}
