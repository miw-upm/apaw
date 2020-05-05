package es.upm.miw.pd.singleton;

public final class Singleton {
    private static Singleton singleton = null; // = new Singleton() // eager

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (Singleton.singleton == null) {
            Singleton.singleton = new Singleton(); // Lazy
        }
        return Singleton.singleton;
    }
}
