package es.upm.miw.pd.composite.treenumbers;

import java.util.ArrayList;
import java.util.List;

public class TreeNumbers {
    private Integer number;

    private String name;

    private List<TreeNumbers> tree;

    public TreeNumbers(String name) {
        this.name = name;
        this.tree = new ArrayList<>();
    }

    public TreeNumbers(Integer number) {
        this.number = number;
        this.tree = null;
    }

    public boolean isComposite() {
        return tree != null;
    }

    public void add(TreeNumbers treeNumbers) {
        assert treeNumbers != null;
        if (!this.isComposite()) {
            throw new UnsupportedOperationException("Operación no soportada");
        } else {
            this.tree.add(treeNumbers);
        }
    }

    public void remove(TreeNumbers treeNumbers) {
        assert treeNumbers != null;
        if (this.isComposite()) {
            this.tree.remove(treeNumbers);
        }
    }

    public int numberOfTreeNumbers() {
        if (this.isComposite()) {
            return this.tree.size();
        } else {
            return 1;
        }
    }

    public int sum() {
        if (this.isComposite()) {
            int result = 0;
            for (TreeNumbers node : this.tree) {
                result += node.sum();
            }
            return result;
        } else {
            return this.number;
        }
    }

    public int higher() {
        if (this.isComposite()) {
            int result = Integer.MIN_VALUE;
            for (TreeNumbers treeNumbers : this.tree) {
                int higher = treeNumbers.higher();
                if (higher > result) {
                    result = higher;
                }
            }
            return result;
        } else {
            return this.number;
        }
    }

    @Override
    public String toString() {
        return "NumberTree[" + name + "]";
    }

}
