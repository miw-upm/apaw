package es.upm.miw.pd.ioc;

public interface ReferencesFactory {

    public abstract int getReference(String key);

    public abstract void removeReference(String key);

}
