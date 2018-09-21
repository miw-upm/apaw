package es.upm.miw.pd.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClazzIoCTest {

    private ClazzIoC clazzIoC;

    @BeforeEach
    void before() {
        clazzIoC = new ClazzIoC();
        clazzIoC.setReferencesFactory(new RandomReferencesFactory());
    }

    @Test
    void testMethod() {
        clazzIoC.method("10");
        clazzIoC.method("11");
    }

}
