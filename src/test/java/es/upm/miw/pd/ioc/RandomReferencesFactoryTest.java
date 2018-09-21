package es.upm.miw.pd.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomReferencesFactoryTest {

    private RandomReferencesFactory randomReferencesFactory;

    @BeforeEach
    void before() {
        randomReferencesFactory = new RandomReferencesFactory();
    }

    @Test
    void testGetReference() {
        int key = randomReferencesFactory.getReference("0");
        assertFalse(0 == key);
        assertEquals(key, randomReferencesFactory.getReference("0"));
    }

    @Test
    void testRemoveReference() {
        int key = randomReferencesFactory.getReference("0");
        randomReferencesFactory.removeReference("0");
        assertFalse(key == randomReferencesFactory.getReference("0"));
    }

}
