package es.upm.miw.pd.observer.project_reactor.solution;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StockFactoryTest {

    @Test
    void testAdd() {
        StockFactoryPublisher stockFactoryPublisher = new StockFactoryPublisher();
        assertNull(stockFactoryPublisher.get(9));
        stockFactoryPublisher.sum(10, 5);
        assertEquals(5, stockFactoryPublisher.get(10));
        stockFactoryPublisher.sum(10, 3);
        assertEquals(8, stockFactoryPublisher.get(10));
    }

    @Test
    void testPublisher() {
        StockFactoryPublisher stockFactoryPublisher = new StockFactoryPublisher();
        StepVerifier
                .create(stockFactoryPublisher.publisher())
                .then(() -> stockFactoryPublisher.sum(10, 5))
                .then(() -> stockFactoryPublisher.sum(12, -6))
                .expectNext(12)
                .then(() -> stockFactoryPublisher.sum(10, -6))
                .expectNext(10)
                .thenCancel()
                .verify();
    }
}
