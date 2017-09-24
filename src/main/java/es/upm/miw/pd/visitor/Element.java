package es.upm.miw.pd.visitor;

public interface Element {
    void accept(Visitor v);
}
