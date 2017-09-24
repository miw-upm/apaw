package es.upm.miw.pd.iterator.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListHandlerTest {
    private LinkedListHandler list;

    @Before
    public void before() {
        LinkedList node = new LinkedList(2);
        node.add(new LinkedList(3));
        node.getNext().add(new LinkedList(4));
        this.list= new LinkedListHandler(node);
    }

    @Test
    public void testSize() {
       assertEquals(3,this.list.size());
    }

    @Test
    public void testSum() {
        assertEquals(9,this.list.sum());
    }

}
