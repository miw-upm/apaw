package es.upm.miw.pd.composite;

public class Leaf1 extends Component {

    public Leaf1(String nombre) {
        super(nombre);
    }

    @Override
    public String view(String cabecera) {
        return cabecera + "-" + this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "H1:" + this.getName().toLowerCase();
    }

    @Override
    public void remove(Component cc) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public void add(Component cc) {
        throw new UnsupportedOperationException("Operación no soportada");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

}
