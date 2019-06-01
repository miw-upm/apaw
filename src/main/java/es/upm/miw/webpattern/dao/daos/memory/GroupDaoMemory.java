package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.GroupDao;
import es.upm.miw.webpattern.dao.entities.Group;

public class GroupDaoMemory extends GenericMemoryDao<Group, String> implements GroupDao {

    @Override
    protected String getId(Group entity) {
        return entity.getId();
    }
}
