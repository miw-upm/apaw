package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.VehicleDao;
import es.upm.miw.webpattern.dao.entities.Vehicle;

public class VehicleDaoMemory extends GenericMemoryDao<Vehicle, Integer> implements VehicleDao {

    @Override
    protected Integer getId(Vehicle entity) {
        return entity.getId();
    }

}
