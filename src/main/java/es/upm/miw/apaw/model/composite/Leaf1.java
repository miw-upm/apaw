package es.upm.miw.apaw.model.composite;

public class Leaf1 extends Component {

    public Leaf1(String name) {
        super(name);
    }

    @Override
    public String view(String head) {
        return head + "-" + this + "\n";
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
