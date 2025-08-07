package es.upm.miw.apaw.model.composite;

import lombok.Data;

@Data
public abstract class Component {
    private final String name;

    public abstract void add(Component cc);
    public abstract void remove(Component cc);
    public abstract boolean isComposite();
    public abstract String view(String head);

}
