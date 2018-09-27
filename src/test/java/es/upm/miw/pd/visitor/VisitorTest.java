package es.upm.miw.pd.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class VisitorTest {

    private List<Element> elementList;

    @BeforeEach
    void before() {
        elementList = new ArrayList<>();
        elementList.add(new ElementA());
        elementList.add(new ElementB());
        elementList.add(new ElementA());
        elementList.add(new ElementB());
        elementList.add(new ElementB());
    }

    @Test
    void testVisitor1() {
        Visitor1 visitor1 = new Visitor1();
        for (Element element : elementList) {
            element.accept(visitor1);
        }
    }

    @Test
    void testVisitor2() {
        Visitor2 visitor2 = new Visitor2();
        for (Element element : elementList) {
            element.accept(visitor2);
        }
        assertEquals(2, visitor2.getAs());
        assertEquals(3, visitor2.getBs());
    }

}
