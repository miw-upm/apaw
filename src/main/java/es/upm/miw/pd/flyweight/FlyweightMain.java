package es.upm.miw.pd.flyweight;

public final class FlyweightMain {
    private FlyweightMain() {
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        FlyweightConcrete[] array = new FlyweightConcrete[5];
        array[0] = factory.get("ocho");
        array[1] = factory.get("tres");
        array[2] = factory.get("ocho");
        array[3] = factory.get("dos");
        array[4] = factory.get("tres");

        for (FlyweightConcrete pesoLigeroConcreto : array) {
            System.out.println(pesoLigeroConcreto.operation("--"));
        }

        for (FlyweightConcrete pesoLigeroConcreto : array) {
            System.out.println(pesoLigeroConcreto.operation(".."));
        }

    }
}
