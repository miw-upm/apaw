package es.upm.miw.webPattern.dao.daos.memory;

import java.util.List;

import es.upm.miw.webPattern.dao.daos.AddressDao;
import es.upm.miw.webPattern.dao.entities.Address;

public class AddressDaoMemory extends GenericMemoryDao<Address, Integer> implements AddressDao {

    @Override
    protected Integer getId(Address entity) {
        return entity.getId();
    }

    @Override
    public List<Address> findByCityAndStreet(String city, String street) {
        return null;
    }

}
