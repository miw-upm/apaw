package es.upm.miw.webpattern.dao.daos;

public abstract class DaoFactory {

    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract UserDao getUserDao();

    public abstract AddressDao getAddressDao();

    public abstract CategoryDao getCategoryDao();

    public abstract PhoneDao getPhoneDao();

    public abstract VehicleDao getVehicleDao();

}
