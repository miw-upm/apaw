package es.upm.miw.pd.decorator;

public abstract class Decorator extends Component {
    private Component c;

    public Decorator(Component c) {
        this.c = c;
    }

    public Component getC() {
        return c;
    }
}
