package es.upm.miw.webpattern.dao.daos.memory;

import es.upm.miw.webpattern.dao.daos.*;

public class DaoFactoryMemory extends DaoFactory {

    private GroupDao groupDao;
    private PhoneDao phoneDao;
    private SuggestionDao suggestionDao;
    private UserDao userDao;
    private VehicleDao vehicleDao;

    @Override
    public GroupDao getGroupDao() {
        if (groupDao == null) {
            groupDao = new GroupDaoMemory();
        }
        return groupDao;
    }

    @Override
    public PhoneDao getPhoneDao() {
        if (phoneDao == null) {
            phoneDao = new PhoneDaoMemory();
        }
        return phoneDao;
    }

    @Override
    public SuggestionDao getSuggestionDao() {
        if (suggestionDao == null) {
            suggestionDao = new SuggestionDaoMemory();
        }
        return suggestionDao;
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

    @Override
    public VehicleDao getVehicleDao() {
        if (vehicleDao == null) {
            vehicleDao = new VehicleDaoMemory();
        }
        return vehicleDao;
    }
}