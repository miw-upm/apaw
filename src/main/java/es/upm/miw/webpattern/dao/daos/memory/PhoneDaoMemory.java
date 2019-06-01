package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.PhoneDao;
import es.upm.miw.webpattern.dao.entities.Phone;

public class PhoneDaoMemory extends GenericMemoryDao<Phone, String> implements PhoneDao {

    @Override
    protected String getId(Phone entity) {
        return entity.getId();
    }
}
