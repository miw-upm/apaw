package es.upm.miw.pd.singleton;

/**
 * <h2>Patrón Singlenton (único)</h2>
 * <p>
 * Se garantiza que una clase sólo tenga una instancia y se proporciona un
 * acceso desde cualquier otra clase
 * </p>
 */
public final class Singleton {
    private static Singleton singleton = null; // = new Singleton() //: creación temprana

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (Singleton.singleton == null) {
            Singleton.singleton = new Singleton(); // Creación perezosa
        }
        return Singleton.singleton;
    }
}
