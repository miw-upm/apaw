package es.upm.miw.pd.builder.user.advanced_solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testFull() {
        User user = User.builder()
                .id("1")
                .nick("Paco")
                .name("Jose")
                .familyName("De Miguel")
                .phone(666666666)
                .age(18)
                .profession("Profesor")
                .tag("Director")
                .tag("socio")
                .tag("Consejo")
                .build();
        assertEquals("1", user.getId());
        assertEquals("Paco", user.getNick());
        assertEquals("Jose", user.getName());
        assertEquals("De Miguel", user.getFamilyName());
        assertEquals(18, user.getAge());
        assertEquals(666666666, user.getPhone());
        assertEquals("Profesor", user.getProfession());
        assertEquals(3, user.getTags().size());
    }

}
