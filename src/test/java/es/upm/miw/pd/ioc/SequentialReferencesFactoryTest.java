package es.upm.miw.pd.ioc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SequentialReferencesFactoryTest {

    SequentialReferencesFactory sequentialReferencesFactory;

    @Before
    public void before() {
        sequentialReferencesFactory = new SequentialReferencesFactory();
    }

    @Test
    public void testGetReference() {
        assertEquals(0, sequentialReferencesFactory.getReference("0"));
        assertEquals(0, sequentialReferencesFactory.getReference("0"));
        assertEquals(1, sequentialReferencesFactory.getReference("1"));
    }

    @Test
    public void testRemoveReference() {
        assertEquals(0, sequentialReferencesFactory.getReference("1"));
        sequentialReferencesFactory.removeReference("1");
        assertEquals(1, sequentialReferencesFactory.getReference("1"));
    }

}
