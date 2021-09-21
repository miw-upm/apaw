package es.upm.miw.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalDemoTest {
    @Test
    void readByIdIsPresent() {
        assertTrue(new OptionalDemo().readById("test").isPresent());
        assertEquals("value", new OptionalDemo().readById("test").get());
    }

    @Test
    void readByIdIsEmpty() {
        assertTrue(new OptionalDemo().readById("0").isEmpty());
    }

    @Test
    void readByIdAssured() {
        assertEquals("default", new OptionalDemo().readByIdAssured("0"));
    }

    @Test
    void readByIdAssuredWithExceptionThrow() {
        assertThrows(RuntimeException.class, () -> new OptionalDemo().readByIdAssuredWithException("0"));
    }

    @Test
    void readByIdAssuredWithExceptionNoThrow() {
        assertEquals("value", new OptionalDemo().readByIdAssuredWithException("test"));
    }
}