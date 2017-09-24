package es.upm.miw.pd.singleton;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void testIsSingleton() {
        assertSame(Singleton.getSingleton(), Singleton.getSingleton());
    }
    
    @Test
    public void testSingletonNotNull() {
        assertNotNull(Singleton.getSingleton());
    }

}
