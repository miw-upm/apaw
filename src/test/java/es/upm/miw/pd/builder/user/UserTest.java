package es.upm.miw.pd.builder.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testUserIntStringStringStringIntIntStringListOfString() {
        User user = new User("id1", "Paco", "Jose", "De Miguel", 25, 666666666,
                "Profesor", Arrays.asList("Director", "Socio", "Consejo"));
        assertEquals("id1", user.getId());
        assertEquals("Paco", user.getNick());
        assertEquals("Jose", user.getName());
        assertEquals("De Miguel", user.getFamilyName());
        assertEquals(25, user.getAge());
        assertEquals(666666666, user.getPhone());
        assertEquals("Profesor", user.getProfession());
        assertEquals(3, user.getTags().size());
    }

}
