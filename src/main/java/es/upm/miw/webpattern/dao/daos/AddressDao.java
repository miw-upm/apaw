package es.upm.miw.webpattern.dao.daos;

import es.upm.miw.webpattern.dao.entities.Address;

import java.util.List;

public interface AddressDao extends GenericDao<Address, Integer> {

    List<Address> findByCityAndStreet(String city, String street);
}
