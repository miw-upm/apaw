package es.upm.miw.webPattern.dao.daos.memory;

import es.upm.miw.webPattern.dao.daos.PhoneDao;
import es.upm.miw.webPattern.dao.entities.Phone;

public class PhoneDaoMemory extends GenericMemoryDao<Phone, Integer> implements PhoneDao {

    @Override
    protected Integer getId(Phone entity) {
        return entity.getId();
    }

}
