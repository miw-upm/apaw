package es.upm.miw.pd.ioc.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClazzTest {

    @BeforeEach
    void before() {
        ReferencesFactory.setReferencesFactory(new RandomReferencesFactory());
    }

    @Test
    void testMethod() {
        Clazz clazz = new Clazz();
        clazz.method("10");
        clazz.method("11");
    }

}
