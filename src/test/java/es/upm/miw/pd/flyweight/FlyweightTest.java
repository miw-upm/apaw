package es.upm.miw.pd.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class FlyweightTest {

    private Factory factory;

    @BeforeEach
    void before() {
        factory = new Factory();
    }

    @Test
    void testGet() {
        assertEquals("ocho", factory.get("ocho").getIntrinseco());
    }

    @Test
    void testSameObject() {
        assertSame(factory.get("ocho"), factory.get("ocho"));
    }

    @Test
    void testOperation() {
        assertEquals("--ocho--", factory.get("ocho").operation("--"));
    }

}
