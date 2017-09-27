package es.upm.miw.pd.ioc.singleton;

public abstract class ReferencesFactory {
    
    private static ReferencesFactory referencesFactory;

    public static ReferencesFactory getReferencesFactory() {
        return referencesFactory;
    }

    public static void setReferencesFactory(ReferencesFactory referencesFactory) {
        ReferencesFactory.referencesFactory = referencesFactory;
    }
    
    public abstract int getReference(String key);

    public abstract void removeReference(String key);


}
