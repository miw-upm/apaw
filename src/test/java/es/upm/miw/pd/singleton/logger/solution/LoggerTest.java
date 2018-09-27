package es.upm.miw.pd.singleton.logger.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LoggerTest {
    @Test
    void testIsSingleton() {
        assertSame(Logger.getLogger(), Logger.getLogger());
    }

    @Test
    void testSingletonNotNull() {
        assertNotNull(Logger.getLogger());
    }

}
