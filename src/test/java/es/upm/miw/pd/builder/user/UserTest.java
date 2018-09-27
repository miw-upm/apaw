package es.upm.miw.pd.builder.user;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserIntStringStringStringIntIntStringListOfString() {
        List<String> tags = new ArrayList<>();
        tags.add("Director");
        tags.add("Socio");
        tags.add("Consejo");
        User user = new User(1, "Paco", "Jose", "De Miguel", 25, 666666666, "Profesor", tags);
        assertEquals(1, user.getId());
        assertEquals("Paco", user.getNick());
        assertEquals("Jose", user.getName());
        assertEquals("De Miguel", user.getFamilyName());
        assertEquals(25, user.getAge());
        assertEquals(666666666, user.getPhone());
        assertEquals("Profesor", user.getProfession());
        assertEquals(3, user.getTags().size());
    }

    @Test
    void testTagContainsFalseNullTags() {
        User user = new User(1, "Paco", null, null, -1, -1, null, null);
        assertFalse(user.tagContains("Not"));
    }

    @Test
    void testTagContainsFalse() {
        List<String> tags = new ArrayList<>();
        tags.add("Director");
        tags.add("Socio");
        User user = new User(1, "Paco");
        user.setPhone(666666666);
        user.setTags(tags);
        assertFalse(user.tagContains("Not"));
    }

    @Test
    void testTagContainsTrue() {
        List<String> tags = new ArrayList<>();
        tags.add("Director");
        tags.add("Socio");
        User user = new User(1, "Paco", null, null, 666666666, -1, null, tags);
        assertTrue(user.tagContains("Director"));
        assertTrue(user.tagContains("Socio"));
    }

}
