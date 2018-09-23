package es.upm.miw.pd.composite.treenumbers.solution;

public class TreeNumbersLeaf extends TreeNumbers {
    private int valor;

    public TreeNumbersLeaf(int valor) {
        this.valor = valor;
    }

    @Override
    public void add(TreeNumbers treeNumbers) {
        throw new UnsupportedOperationException("Unsupported operation in leaf");
    }

    @Override
    public void remove(TreeNumbers treeNumbers) {
        //Do nothing because is a leaf
    }

    @Override
    public int sum() {
        return this.valor;
    }

    @Override
    public int higher() {
        return this.valor;
    }

    @Override
    public int number() {
        return 1;
    }

    @Override
    public String toString() {
        return "Leaf[" + valor + "]";
    }

}
