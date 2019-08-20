package es.upm.miw.pd.observer.project_reactor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StockFactoryTest {

    @Test
    void testAdd() {
        StockFactory stockFactory = new StockFactory();
        assertNull(stockFactory.get(9));
        stockFactory.sum(10, 5);
        assertEquals(5, stockFactory.get(10));
        stockFactory.sum(10, 3);
        assertEquals(8, stockFactory.get(10));
    }
}
