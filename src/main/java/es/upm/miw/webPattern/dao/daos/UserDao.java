package es.upm.miw.webPattern.dao.daos;

import java.util.List;

import es.upm.miw.webPattern.dao.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    
    public List<User> findByName(String name);

}
