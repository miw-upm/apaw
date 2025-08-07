package es.upm.miw.apaw.persistence.mongodb.repositories;

import es.upm.miw.apaw.persistence.mongodb.documents.UnRelatedDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UnRelatedRepository extends MongoRepository<UnRelatedDocument, UUID> {

    UnRelatedDocument findByNicknameIgnoreCase(String nickname);

    List<UnRelatedDocument> findFirst3ByNicknameStartingWith(String prefix);

    List<UnRelatedDocument> findByNicknameOrLargeOrderByLongerDesc(String nickname, String large);

    List<UnRelatedDocument> findByIntegerGreaterThan(int integer, Pageable pageable);

    @Transactional
    int deleteByNickname(String nickname);

    // @Query("{'nickname':?0}") // Query NOT necessary
    Optional<UnRelatedDocument> findByNickname(String nickname);

    // @Query("{$and:[{'nickname':?0},{'large':?1}]}") // Query NOT necessary
    UnRelatedDocument findByNicknameAndLarge(String nickname, String large);

    // @Query("{nickname:{$in:?0} }") // Query NOT necessary
    List<UnRelatedDocument> findByNicknameIn(List<String> nicknames);

    @Query("{$and:[" //  //$options: 'i': Case insensitivity & allow NULL: all elements
            + "?#{ [0] == null ? {_id : {$ne:null}} : { nickname : {$regex:[0], $options: 'i'} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { large : {$regex:[1], $options: 'i'} } }"
            + "] }")
    List<UnRelatedDocument> findByNicknameLikeAndLargeLikeNullSafe(String nick, String large);

}
