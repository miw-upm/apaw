package es.upm.miw.apaw.model.singleton;

import es.upm.miw.apaw.model.singleton.Singleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;


class SingletonTest {
    @Test
    void testIsSingleton() {
        assertSame(Singleton.getInstance(), Singleton.getInstance());
    }

    @Test
    void testSingletonNotNull() {
        assertNotNull(Singleton.getInstance());
    }

}
