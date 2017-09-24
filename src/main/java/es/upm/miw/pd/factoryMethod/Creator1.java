package es.upm.miw.pd.factoryMethod;

public class Creator1 extends Creator {
    @Override
    public Product crearProducto() {
        return new Product1();
    }

    @Override
    public String toString() {
        return "Creador de Producto1";
    }
}
