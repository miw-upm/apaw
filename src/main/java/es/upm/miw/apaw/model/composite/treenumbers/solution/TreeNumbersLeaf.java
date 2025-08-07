package es.upm.miw.apaw.model.composite.treenumbers.solution;

import lombok.ToString;

@ToString
public class TreeNumbersLeaf implements TreeNumbers {
    private final int valor;

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


}
