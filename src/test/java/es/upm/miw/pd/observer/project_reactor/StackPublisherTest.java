package es.upm.miw.pd.observer.project_reactor;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackPublisherTest {

    @Test
    void testStack() {
        StackPublisher stackPublisher = new StackPublisher();

        stackPublisher.publisher().subscribe(
                msg -> LogManager.getLogger(this.getClass()).info("Consumer: " + msg), //onNext
                throwable -> LogManager.getLogger(this.getClass()).info("Error: " + throwable.getMessage()), //onError
                () -> LogManager.getLogger(this.getClass()).info("Completed") //onComplete
        );
        stackPublisher.add("one");
        stackPublisher.add("two");
        stackPublisher.add("three");
        assertEquals(3, stackPublisher.getValues().size());
        stackPublisher.reset();
        assertEquals(0, stackPublisher.getValues().size());
        stackPublisher.add("four");
    }


}
