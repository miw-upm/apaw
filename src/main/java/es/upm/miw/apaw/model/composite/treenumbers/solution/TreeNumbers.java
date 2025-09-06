package es.upm.miw.apaw.model.composite.treenumbers.solution;

public interface TreeNumbers {
    void add(TreeNumbers treeNumbers);

    void remove(TreeNumbers treeNumbers);

    int number();

    int sum();

    int higher();
}
