package es.upm.miw.pd.composite.treenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeNumbers {

    private Integer number;

    private String name;

    private List<TreeNumbers> treeNumbersList;

    public TreeNumbers(String name) {
        this.name = name;
        this.treeNumbersList = new ArrayList<>();
    }

    public TreeNumbers(Integer number) {
        this.number = number;
        this.treeNumbersList = null;
    }

    public boolean isComposite() {
        return treeNumbersList != null;
    }

    public void add(TreeNumbers treeNumbers) {
        if (!this.isComposite()) {
            throw new UnsupportedOperationException("Unsupported operation in leaf");
        } else {
            this.treeNumbersList.add(treeNumbers);
        }
    }

    public void remove(TreeNumbers treeNumbers) {
        if (this.isComposite()) {
            this.treeNumbersList.remove(treeNumbers);
        }
    }

    public int numberOfNodes() {
        if (this.isComposite()) {
            return this.treeNumbersList.size();
        } else {
            return 1;
        }
    }

    public int sum() {
        if (this.isComposite()) {
            return this.treeNumbersList.stream().mapToInt(TreeNumbers::sum).sum();
        } else {
            return this.number;
        }
    }

    public int higher() {
        if (this.isComposite()) {
            return this.treeNumbersList.stream().mapToInt(TreeNumbers::higher).max().orElseThrow(NoSuchElementException::new);
        } else {
            return this.number;
        }
    }

    @Override
    public String toString() {
        return "NumberTree[" + name + "]";
    }

}
