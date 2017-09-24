package es.upm.miw.pd.iterator.linkedList.solution;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer>{
    private int value;

    private LinkedList next;

    public LinkedList(int value) {
        this.value = value;
        this.next = null;
    }

    public boolean isLast() {
        return this.next == null;
    }

    public int getValue() {
        return this.value;
    }

    protected LinkedList getNext() {
        return this.next;
    }

    public void add(LinkedList node) {
        node.next = this.next;
        this.next = node;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }
}
