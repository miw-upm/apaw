package es.upm.miw.pd.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequentialReferencesFactoryTest {

    private SequentialReferencesFactory sequentialReferencesFactory;

    @BeforeEach
    void before() {
        sequentialReferencesFactory = new SequentialReferencesFactory();
    }

    @Test
    void testGetReference() {
        assertEquals(0, sequentialReferencesFactory.getReference("0"));
        assertEquals(0, sequentialReferencesFactory.getReference("0"));
        assertEquals(1, sequentialReferencesFactory.getReference("1"));
    }

    @Test
    void testRemoveReference() {
        assertEquals(0, sequentialReferencesFactory.getReference("1"));
        sequentialReferencesFactory.removeReference("1");
        assertEquals(1, sequentialReferencesFactory.getReference("1"));
    }

}
