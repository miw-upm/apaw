package es.upm.miw.pd.singleton.logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import es.upm.miw.pd.singleton.logger.solution.Logger;

public class LoggerTest {
    @Test
    public void testIsSingleton() {
        assertSame(Logger.getLogger(), Logger.getLogger());
    }

    @Test
    public void testSingletonNotNull() {
        assertNotNull(Logger.getLogger());
    }
    
}
