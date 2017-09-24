package es.upm.miw.pd.iterator.linkedList;

public class LinkedList {
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

    public LinkedList getNext() {
        return this.next;
    }

    public void add(LinkedList node) {
        node.next = this.next;
        this.next = node;
    }
}
