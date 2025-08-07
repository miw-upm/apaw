package es.upm.miw.apaw.model.composite;

public abstract class Component {
    private final String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void add(Component cc);

    public abstract void remove(Component cc);

    public abstract boolean isComposite();

    public abstract String view(String head);

}
