package es.upm.miw.pd.factoryMethod;

public class Creator2 extends Creator {
    @Override
    public Product crearProducto() {
        return new Product2();
    }

    @Override
    public String toString() {
        return "Creador de Producto2";
    }
}
