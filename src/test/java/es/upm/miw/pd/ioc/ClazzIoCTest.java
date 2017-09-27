package es.upm.miw.pd.ioc;

import org.junit.Before;
import org.junit.Test;

public class ClazzIoCTest {

    ClazzIoC clazzIoC;

    @Before
    public void before() {
        clazzIoC = new ClazzIoC();
        clazzIoC.setReferencesFactory(new RandomReferencesFactory());
    }

    @Test
    public void testMethod() {
        clazzIoC.method("10");
        clazzIoC.method("11");
    }

}
