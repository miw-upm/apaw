package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.AddressDao;
import es.upm.miw.webpattern.dao.daos.CategoryDao;
import es.upm.miw.webpattern.dao.daos.DaoFactory;
import es.upm.miw.webpattern.dao.daos.PhoneDao;
import es.upm.miw.webpattern.dao.daos.UserDao;
import es.upm.miw.webpattern.dao.daos.VehicleDao;

public class DaoFactoryMemory extends DaoFactory {
    
    private AddressDao addressDao;
    private CategoryDao categoryDao;
    private PhoneDao phoneDao;
    private UserDao userDao;
    private VehicleDao vehicleDao;


    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

    @Override
    public AddressDao getAddressDao() {
        if (addressDao == null) {
            addressDao = new AddressDaoMemory();
        }
        return addressDao;
    }

    @Override
    public CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDaoMemory();
        }
        return categoryDao;
    }

    @Override
    public PhoneDao getPhoneDao() {
        if (phoneDao == null) {
            phoneDao = new PhoneDaoMemory();
        }
        return phoneDao;
   }

    @Override
    public VehicleDao getVehicleDao() {
        if (vehicleDao == null) {
            vehicleDao = new VehicleDaoMemory();
        }
        return vehicleDao;
    }

}
