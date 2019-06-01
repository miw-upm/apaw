package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.VehicleDao;
import es.upm.miw.webpattern.dao.entities.Vehicle;

public class VehicleDaoMemory extends GenericMemoryDao<Vehicle, String> implements VehicleDao {

    @Override
    protected String getId(Vehicle entity) {
        return entity.getId();
    }
}
