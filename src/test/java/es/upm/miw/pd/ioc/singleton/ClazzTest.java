package es.upm.miw.pd.ioc.singleton;

import org.junit.Before;
import org.junit.Test;

public class ClazzTest {

    @Before
    public void before() {
        ReferencesFactory.setReferencesFactory(new RandomReferencesFactory());
    }

    @Test
    public void testMethod() {
        Clazz clazz = new Clazz();
        clazz.method("10");
        clazz.method("11");
    }

}
