package es.upm.miw.webpattern.dao.daos;

import java.util.List;

import es.upm.miw.webpattern.dao.entities.Address;

public interface AddressDao extends GenericDao<Address, Integer>{

   List<Address> findByCityAndStreet(String city, String street);
}
