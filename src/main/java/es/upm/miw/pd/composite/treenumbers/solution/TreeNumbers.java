package es.upm.miw.pd.composite.treenumbers.solution;

public abstract class TreeNumbers {
    public abstract void add(TreeNumbers treeNumbers);

    public abstract void remove(TreeNumbers treeNumbers);

    public abstract int numberOfTreeNumbers();

    public abstract int sum();

    public abstract int higher();
}
