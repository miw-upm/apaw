package es.upm.miw.apaw.pd.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RandomReferencesFactoryTest {

    private RandomReferencesFactory randomReferencesFactory;

    @BeforeEach
    void before() {
        randomReferencesFactory = new RandomReferencesFactory();
    }

    @Test
    void testGetReference() {
        int key = randomReferencesFactory.getReference("0");
        assertNotEquals(0, key);
        assertEquals(key, randomReferencesFactory.getReference("0"));
    }

    @Test
    void testRemoveReference() {
        int key = randomReferencesFactory.getReference("0");
        randomReferencesFactory.removeReference("0");
        assertNotEquals(key, randomReferencesFactory.getReference("0"));
    }

}
