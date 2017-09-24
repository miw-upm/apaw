package es.upm.miw.webPattern.dao.daos.memory;

import es.upm.miw.webPattern.dao.daos.CategoryDao;
import es.upm.miw.webPattern.dao.entities.Category;

public class CategoryDaoMemory extends GenericMemoryDao<Category, Integer> implements CategoryDao {
    @Override
    protected Integer getId(Category entity) {
        return entity.getId();
    }

}
