package es.upm.miw.apaw.model.composite.treenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeNumbers {

    private final List<TreeNumbers> treeNumbersList;
    private Integer number;
    private String name;

    public TreeNumbers(String name) {
        this.name = name;
        this.treeNumbersList = new ArrayList<>();
    }

    public TreeNumbers(Integer number) {
        this.number = number;
        this.treeNumbersList = null;
    }

    public boolean isComposite() {
        return this.treeNumbersList != null;
    }

    public void add(TreeNumbers treeNumbers) {
        if (this.isComposite()) {
            this.treeNumbersList.add(treeNumbers);
        } else {
            throw new UnsupportedOperationException("Unsupported operation in leaf");
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
            return this.treeNumbersList.stream()
                    .mapToInt(TreeNumbers::sum)
                    .sum();
        } else {
            return this.number;
        }
    }

    public int higher() {
        if (this.isComposite()) {
            return this.treeNumbersList.stream()
                    .mapToInt(TreeNumbers::higher)
                    .max()
                    .orElseThrow(NoSuchElementException::new);
        } else {
            return this.number;
        }
    }

    @Override
    public String toString() {
        return "TreeNumbers{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", treeNumbersList=" + treeNumbersList +
                '}';
    }
}
