package es.upm.miw.pd.singleton.logger;

import org.junit.jupiter.api.Test;

import es.upm.miw.pd.singleton.logger.solution.Logger;

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
