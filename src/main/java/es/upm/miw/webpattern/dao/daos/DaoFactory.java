package es.upm.miw.webpattern.dao.daos;

public abstract class DaoFactory {

    public static DaoFactory factory = null;

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public abstract GroupDao getGroupDao();

    public abstract PhoneDao getPhoneDao();

    public abstract SuggestionDao getSuggestionDao();

    public abstract UserDao getUserDao();

    public abstract VehicleDao getVehicleDao();
}
