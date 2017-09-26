package es.upm.miw.pd.visitor.figure.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FigureTest {
    FiguresManager figuresManager;

    @Before
    public void before() {
        figuresManager = new FiguresManager();
        figuresManager.add(new Circle("circle", 4.0));
        figuresManager.add(new Triangle("triangle", 2.0, 2.0));
        figuresManager.add(new Square("square", 3.0));        
    }

    @Test
    public void testTotalArea() {
        assertEquals(61.265, figuresManager.totalArea(),10e-3);
    }
    
    @Test
    public void testTotalNumberOfSides() {
        assertEquals(Double.POSITIVE_INFINITY, figuresManager.totalNumberOfSides(),10e-3);
    }

}
