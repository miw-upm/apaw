package es.upm.miw.apaw.pd.decorator;

public abstract class Decorator extends Component {

    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }
}
