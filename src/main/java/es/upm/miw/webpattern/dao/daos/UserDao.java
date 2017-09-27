package es.upm.miw.webpattern.dao.daos;

import java.util.List;

import es.upm.miw.webpattern.dao.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    
    List<User> findByName(String name);

}
