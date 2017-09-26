package es.upm.miw.pd.flyweight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class FlyweightTest {
    Factory factory;

    @Before
    public void before() {
        factory = new Factory();
    }

    @Test
    public void testGet() {
        assertEquals("ocho", factory.get("ocho").getIntrinseco());
    }

    @Test
    public void testSameObject() {
        assertSame(factory.get("ocho"), factory.get("ocho"));
    }

    @Test
    public void testOperation() {
        assertEquals("--ocho--", factory.get("ocho").operation("--"));
    }

}
