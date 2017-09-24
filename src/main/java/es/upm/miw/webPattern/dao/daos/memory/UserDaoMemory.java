package es.upm.miw.webPattern.dao.daos.memory;

import java.util.List;

import es.upm.miw.webPattern.dao.daos.UserDao;
import es.upm.miw.webPattern.dao.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User, Integer> implements UserDao {

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

}
