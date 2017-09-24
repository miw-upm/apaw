package es.upm.miw.pd.iterator.linkedList.solution;

import java.util.Iterator;

public class LinkedListHandler {
    public Iterable<Integer> list;

    public LinkedListHandler(Iterable<Integer> list) {
        assert list != null;
        this.list = list;
    }

    public int size() {
        Iterator<Integer> iterator = this.list.iterator();
        int count = 1;
        while (!iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    public int sum() {
        Iterator<Integer> iterator = this.list.iterator();
        int total = 0;
        while (!iterator.hasNext()) {
            total += iterator.next();
        }
        return total;
    }
}
