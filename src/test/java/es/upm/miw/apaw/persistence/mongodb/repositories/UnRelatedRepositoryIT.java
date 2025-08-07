package es.upm.miw.apaw.persistence.mongodb.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.miw.apaw.persistence.mongodb.documents.Gender;
import es.upm.miw.apaw.persistence.mongodb.documents.UnRelatedDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UnRelatedRepositoryIT {

    @Autowired
    private UnRelatedRepository unRelatedRepository;

    @BeforeEach
    void populate() {
        Stream<UnRelatedDocument> documents = Stream.iterate(0, i -> i + 1).limit(5L).map(i ->
                UnRelatedDocument.builder()
                        .id(UUID.randomUUID())
                        .nickname("nick" + i)
                        .gender(Gender.FEMALE)
                        .dateOfBirth(LocalDateTime.now())
                        .tags(new String[]{"uno", "dos"}).large("Large...").noPersistent("noPersistent")
                        .active(true).integer(666).decimal(666.666e30)
                        .longer(LocalDateTime.now().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli()).build()
        );
        this.unRelatedRepository.saveAll(documents.toList());
    }

    @Test
    void testNotEmpty() throws JsonProcessingException {
        this.unRelatedRepository.deleteAll();
        this.unRelatedRepository.save(UnRelatedDocument.builder().id(UUID.randomUUID()).nickname("nick1").build());
        this.unRelatedRepository.save(UnRelatedDocument.builder().id(UUID.randomUUID()).nickname("nick1").large("large").build());
        List<UnRelatedDocument> docs = unRelatedRepository.findAll();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(docs));
        assertFalse(docs.isEmpty());
    }

    @Test
    void testFindByNicknameIgnoreCase() {
        assertNotNull(unRelatedRepository.findByNicknameIgnoreCase("NICK1"));
    }

    @Test
    void testFindFirst3ByNicknameStartingWith() {
        assertEquals(0, unRelatedRepository.findFirst3ByNicknameStartingWith("no").size());
        assertEquals(3, unRelatedRepository.findFirst3ByNicknameStartingWith("ni").size());
    }

    @Test
    void testFindByNickOrLargeOrderByIdDesc() {
        assertTrue(unRelatedRepository.findByNicknameOrLargeOrderByLongerDesc(
                "NoNick", "Large...").get(0).getLonger() >= unRelatedRepository
                .findByNicknameOrLargeOrderByLongerDesc("NoNick", "Large...").get(1).getLonger());
        assertEquals(5, unRelatedRepository.findByNicknameOrLargeOrderByLongerDesc("NoNick", "Large...").size());
    }

    @Test
    void testFindByIntegerGreaterThan() {
        assertEquals(2, unRelatedRepository.findByIntegerGreaterThan(0, PageRequest.of(0, 2)).size());
        assertEquals(2, unRelatedRepository.findByIntegerGreaterThan(0, PageRequest.of(1, 3)).size());
    }

    @Test
    void testDeleteByNickname() {
        assertNotNull(unRelatedRepository.findByNickname("nick0"));
        assertTrue(0 < unRelatedRepository.deleteByNickname("nick0"));
        assertFalse(unRelatedRepository.findByNickname("nick0").isPresent());
    }

    @Test
    void testFindByNickname() {
        assertNotNull(unRelatedRepository.findByNickname("nick0"));
    }

    @Test
    void testFindByNicknameAndLarge() {
        assertNotNull(unRelatedRepository.findByNicknameAndLarge("nick0", "Large..."));
        assertNull(unRelatedRepository.findByNicknameAndLarge("nick0", "NOT"));
    }

    @Test
    void testFindByNicknameIn() {
        assertEquals(2, unRelatedRepository.findByNicknameIn(Arrays.asList("nick1", "nick2")).size());
    }

    @Test
    void testFindByNicknameLikeLargeLikeNullSafe() {
        assertEquals(0, unRelatedRepository.findByNicknameLikeAndLargeLikeNullSafe("k1", "no").size());
        assertEquals(1, unRelatedRepository.findByNicknameLikeAndLargeLikeNullSafe("k1", null).size());
        assertEquals(5, unRelatedRepository.findByNicknameLikeAndLargeLikeNullSafe(null, null).size());
    }

    @AfterEach
    void deleteDB() {
        this.unRelatedRepository.deleteAll();
    }

}
