package es.upm.miw.apaw.model.builder.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testUserIntStringStringStringIntIntStringListOfString() {
        UUID id = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeffff0000");
        User user = new User(id, "Paco", "Jose",
                "De Miguel", 25, 666666666, "Profesor", Arrays.asList("Director", "Socio", "Consejo"));
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getNick()).isEqualTo("Paco");
        assertThat(user.getName()).isEqualTo("Jose");
        assertThat(user.getFamilyName()).isEqualTo("De Miguel");
        assertThat(user.getAge()).isEqualTo(25);
        assertThat(user.getPhone()).isEqualTo(666666666);
        assertThat(user.getProfession()).isEqualTo("Profesor");
        assertThat(user.getTags()).hasSize(3);
    }

}
