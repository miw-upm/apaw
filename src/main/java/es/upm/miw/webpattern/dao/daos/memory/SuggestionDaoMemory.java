package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.SuggestionDao;
import es.upm.miw.webpattern.dao.entities.Suggestion;

public class SuggestionDaoMemory extends GenericMemoryDao<Suggestion, String> implements SuggestionDao {

    @Override
    protected String getId(Suggestion entity) {
        return entity.getId();
    }
}
