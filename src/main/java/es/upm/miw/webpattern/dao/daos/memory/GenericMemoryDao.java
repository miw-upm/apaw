package es.upm.miw.webpattern.dao.daos.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.upm.miw.webpattern.dao.daos.GenericDao;


public abstract class GenericMemoryDao<T, ID> implements GenericDao<T, ID> {

    private Map<ID, T> map;

    protected void setMap(Map<ID, T> map) {
        this.map = map;
    }

    @Override
    public void create(T entity) {
        map.put(this.getId(entity), entity);
    }

    @Override
    public T read(ID id) {
        return map.get(id);
    }

    @Override
    public void update(T entity) {
        if (map.containsKey(this.getId(entity))) {
            map.put(this.getId(entity), entity);
        }
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    protected abstract ID getId(T entity);

}
