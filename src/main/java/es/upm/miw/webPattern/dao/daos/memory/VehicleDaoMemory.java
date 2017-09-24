package es.upm.miw.webPattern.dao.daos.memory;

import es.upm.miw.webPattern.dao.daos.VehicleDao;
import es.upm.miw.webPattern.dao.entities.Vehicle;

public class VehicleDaoMemory extends GenericMemoryDao<Vehicle, Integer> implements VehicleDao {

    @Override
    protected Integer getId(Vehicle entity) {
        return entity.getId();
    }

}
