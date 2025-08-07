package es.upm.miw.apaw.model.builder.user.advancesoluition;

import es.upm.miw.apaw.model.builder.user.advancedsolution.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testFull() {
        UUID id = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");
        User user = User.builder()
                .id(id)
                .nick("Paco")
                .name("Jose")
                .familyName("De Miguel")
                .phone(666666666)
                .age(25)
                .profession("Profesor")
                .tag("Director")
                .tag("socio")
                .tag("Consejo")
                .build();
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getNick()).isEqualTo("Paco");
        assertThat(user.getName()).isEqualTo("Jose");
        assertThat(user.getFamilyName()).isEqualTo("De Miguel");
        assertThat(user.getAge()).isEqualTo(25);
        assertThat(user.getPhone()).isEqualTo(666666666);
        assertThat(user.getProfession()).isEqualTo("Profesor");
        assertThat(user.getTags()).hasSize(3);
    }

    @Test
    void testPartial() {
        UUID id = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0001");
        User user = User.builder().id(id).nick("Paco").name("Jose").tag("Director").age(25).build();
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getNick()).isEqualTo("Paco");
        assertThat(user.getName()).isEqualTo("Jose");
        assertThat(user.getAge()).isEqualTo(25);
        assertEquals(1, user.getTags().size());
    }

}
