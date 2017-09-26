package es.upm.miw.pd.visitor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VisitorTest {

    List<Element> elementList;

    @Before
    public void before() {
        elementList = new ArrayList<>();
        elementList.add(new ElementA());
        elementList.add(new ElementB());
        elementList.add(new ElementA());
        elementList.add(new ElementB());
        elementList.add(new ElementB()); 
    }
    
    @Test
    public void testVisitor1() {
        Visitor1 visitor1 = new Visitor1();
        for (Element element : elementList) {
            element.accept(visitor1);
        }
    }
    
    @Test
    public void testVisitor2() {
        Visitor2 visitor2 = new Visitor2();
        for (Element element : elementList) {
            element.accept(visitor2);
        }
        assertEquals(2,visitor2.getAs());
        assertEquals(3,visitor2.getBs());
    }

}
