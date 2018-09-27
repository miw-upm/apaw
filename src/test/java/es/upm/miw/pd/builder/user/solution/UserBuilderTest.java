package es.upm.miw.pd.builder.user.solution;

import es.upm.miw.pd.builder.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserBuilderTest {

    @Test
    void testFull() {
        User user = new UserBuilder(1, "Paco").name("Jose").familyName("De Miguel").phone(666666666).adult()
                .profession("Profesor").tag("Director").tag("socio").tag("Consejo").build();
        assertEquals(1, user.getId());
        assertEquals("Paco", user.getNick());
        assertEquals("Jose", user.getName());
        assertEquals("De Miguel", user.getFamilyName());
        assertEquals(18, user.getAge());
        assertEquals(666666666, user.getPhone());
        assertEquals("Profesor", user.getProfession());
        assertEquals(3, user.getTags().size());
    }

    @Test
    void testTagContainsFalseNullTags() {
        User user = new UserBuilder(1, "Paco").build();
        assertFalse(user.tagContains("Not"));
    }

    @Test
    void testTagContainsFalse() {
        User user = new UserBuilder(1, "Paco").tag("Director").tag("Socio").phone(666666666).build();
        assertFalse(user.tagContains("Not"));
    }

    @Test
    void testTagContainsTrue() {
        User user = new UserBuilder(1, "Paco").tag("Director").tag("Socio").build();
        assertTrue(user.tagContains("Director"));
        assertTrue(user.tagContains("Socio"));
    }

    @Test
    void testByDefault() {
        User user = new UserBuilder().byDefault().tag("Director").tag("Socio").build();
        assertTrue(user.tagContains("Director"));
        assertTrue(user.tagContains("Socio"));
    }

}
