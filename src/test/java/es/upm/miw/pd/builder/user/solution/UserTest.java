package es.upm.miw.pd.builder.user.solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.upm.miw.pd.builder.user.User;

public class UserTest {

    @Test
    public void testUserIntStringStringStringIntIntStringListOfString() {
        User user = new UserBuilder().id(1).nick("Paco").name("Jose").familyName("De Miguel").age(18).phone(666666666)
                .profession("Profesor").tag("Director").tag("socio").tag("Consejo").build();
        user = new UserBuilder().id(1).nick("Paco").name("Jose").familyName("De Miguel").phone(666666666).adult().profession("Profesor")
                .tag("Director").tag("socio").tag("Consejo").build();
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
    public void testTagContainsFalseNullTags() {
        User user = new UserBuilder().id(1).nick("Paco").build();
        assertFalse(user.tagContains("Not"));
    }

    @Test
    public void testTagContainsFalse() {
        User user = new UserBuilder().id(1).nick("Paco").tag("Director").tag("Socio").phone(666666666).build();
        assertFalse(user.tagContains("Not"));
    }

    @Test
    public void testTagContainsTrue() {
        User user = new UserBuilder().byDefault().tag("Director").tag("Socio").build();
        assertTrue(user.tagContains("Director"));
        assertTrue(user.tagContains("Socio"));
    }

}
