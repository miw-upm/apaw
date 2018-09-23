package es.upm.miw.pd.composite.treenumbers.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeNumbersComposite extends TreeNumbers {

    private String name;

    private List<TreeNumbers> treeNumbersList;

    public TreeNumbersComposite(String name) {
        this.name = name;
        this.treeNumbersList = new ArrayList<>();
    }

    @Override
    public void add(TreeNumbers treeNumbers) {
        this.treeNumbersList.add(treeNumbers);
    }

    @Override
    public void remove(TreeNumbers treeNumbers) {
        this.treeNumbersList.remove(treeNumbers);
    }

    @Override
    public int sum() {
        return this.treeNumbersList.stream().mapToInt(TreeNumbers::sum).sum();
    }

    @Override
    public int higher() {
        return this.treeNumbersList.stream().mapToInt(TreeNumbers::higher).max().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public int number() {
        return this.treeNumbersList.size();
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }

}
