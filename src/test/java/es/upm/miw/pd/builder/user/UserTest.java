package es.upm.miw.pd.builder.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserTest {

    @Test
    public void testUserIntStringStringStringIntIntStringListOfString(){
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
    public void testTagContainsFalseNullTags(){
        List<String> tags = null;
        User user = new User(1, "Paco", null, null, -1, -1, null, tags);
        assertFalse(user.tagContains("Not"));
    }
    
    @Test
    public void testTagContainsFalse(){
        List<String> tags = new ArrayList<>();
        tags.add("Director");
        tags.add("Socio");
        User user = new User(1, "Paco");
        user.setPhone(666666666);
        user.setTags(tags);
        assertFalse(user.tagContains("Not"));
    }
    
    @Test
    public void testTagContainsTrue(){
        List<String> tags = new ArrayList<>();
        tags.add("Director");
        tags.add("Socio");
        User user = new User(1, "Paco", null, null, 666666666, -1, null, tags);
        assertTrue(user.tagContains("Director"));
        assertTrue(user.tagContains("Socio"));
    }

}
