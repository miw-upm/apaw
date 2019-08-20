package es.upm.miw.pd.observer.project_reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackPublisherTest {

    @Test
    void testStack() {
        StackPublisher stackPublisher = new StackPublisher();
        stackPublisher.add("one");
        stackPublisher.add("two");
        stackPublisher.add("three");
        assertEquals(3, stackPublisher.getValues().size());
        stackPublisher.reset();
        assertEquals(0, stackPublisher.getValues().size());
        stackPublisher.add("four");
    }

    @Test
    void testStackPublisher() {
        StackPublisher stackPublisher = new StackPublisher();
        StepVerifier
                .create(stackPublisher.publisher())
                .then(() -> stackPublisher.add("One"))
                .expectNext("One")
                .then(() -> stackPublisher.add("Two"))
                .expectNext("Two")
                .thenCancel()
                .verify();
    }
}
