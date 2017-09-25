package es.upm.miw.pd.composite.treenumbers.solution;

import java.util.ArrayList;
import java.util.List;

public class TreeNumbersComposite extends TreeNumbers {
    private String nombre;

    private List<TreeNumbers> lista;

    public TreeNumbersComposite(String nombre) {
        this.nombre = nombre;
        this.lista = new ArrayList<>();
    }

    @Override
    public void add(TreeNumbers treeNumbers) {
        assert treeNumbers != null;
        this.lista.add(treeNumbers);
    }

    @Override
    public void remove(TreeNumbers treeNumbers) {
        assert treeNumbers != null;
        this.lista.remove(treeNumbers);
    }

    @Override
    public int sum() {
        int result = 0;
        for (TreeNumbers treeNumbers : this.lista) {
            result += treeNumbers.sum();
        }
        return result;
    }

    @Override
    public int higher() {
        int result = Integer.MIN_VALUE;
        for (TreeNumbers treeNumbers : this.lista) {
            int higher = treeNumbers.higher();
            if (higher > result) {
                result = higher;
            }
        }
        return result;
    }

    @Override
    public int numberOfTreeNumbers() {
        return this.lista.size();
    }

    @Override
    public String toString() {
        return "[" + this.nombre + "]";
    }

}
