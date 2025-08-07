package es.upm.miw.apaw.pd.ioc;

public interface ReferencesFactory {

    int getReference(String key);

    void removeReference(String key);

}
