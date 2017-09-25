package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.CategoryDao;
import es.upm.miw.webpattern.dao.entities.Category;

public class CategoryDaoMemory extends GenericMemoryDao<Category, Integer> implements CategoryDao {
    @Override
    protected Integer getId(Category entity) {
        return entity.getId();
    }

}
