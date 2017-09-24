package es.upm.miw.pd.iterator.linkedList.solution;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Integer> {

    private LinkedList node;

    public LinkedListIterator(LinkedList node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return this.node != null;
    }

    @Override
    public Integer next() {
        LinkedList old = this.node;
        this.node = this.node.getNext();
        return old.getValue();
    }

}
