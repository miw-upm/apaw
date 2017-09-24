package es.upm.miw.webPattern.dao.daos;

import java.util.List;

import es.upm.miw.webPattern.dao.entities.Address;

public interface AddressDao extends GenericDao<Address, Integer>{

    public List<Address> findByCityAndStreet(String city, String street);
}
