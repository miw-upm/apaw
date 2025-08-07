package es.upm.miw.apaw.model.singleton.factory;

import es.upm.miw.apaw.model.singleton.factory.ReferencesFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReferencesFactoryTest {

    @Test
    void testGetReference() {
        ReferencesFactory referencesFactory = new ReferencesFactory();
        assertEquals(0, referencesFactory.getReference("one"));
        assertEquals(1, referencesFactory.getReference("two"));
    }

    @Test
    void testRemoveReference() {
        ReferencesFactory referencesFactory = new ReferencesFactory();
        assertEquals(0, referencesFactory.getReference("one"));
        referencesFactory.removeReference("one");
        assertEquals(1, referencesFactory.getReference("one"));
    }

}
