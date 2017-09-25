package es.upm.miw.pd.ioc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomReferencesFactoryTest {

    RandomReferencesFactory randomReferencesFactory;

    @Before
    public void before() {
        randomReferencesFactory = new RandomReferencesFactory();
    }

    @Test
    public void testGetReference() {
        int key = randomReferencesFactory.getReference("0");
        assertFalse(0 == key);
        assertEquals(key, randomReferencesFactory.getReference("0"));
    }

    @Test
    public void testRemoveReference() {
        int key = randomReferencesFactory.getReference("0");
        randomReferencesFactory.removeReference("0");
        assertFalse(key == randomReferencesFactory.getReference("0"));
    }

}
