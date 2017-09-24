package es.upm.miw.pd.singleton;

/**
 * <h2>Patrón Singlenton (único)</h2>
 * <p>
 * Se garantiza que una clase sólo tenga una instancia y se proporciona un
 * acceso desde cualquier otra clase
 * </p>
 */
public final class Singleton {
    // Aqui se crea para creación temprana
    private static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        // Creación perezosa
        if (Singleton.singleton == null) {
            Singleton.singleton = new Singleton();
        }
        return Singleton.singleton;
    }
}
