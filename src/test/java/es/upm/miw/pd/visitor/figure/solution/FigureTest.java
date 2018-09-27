package es.upm.miw.pd.visitor.figure.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FigureTest {
    private FiguresManager figuresManager;

    @BeforeEach
    void before() {
        figuresManager = new FiguresManager();
        figuresManager.add(new Circle("circle", 4.0));
        figuresManager.add(new Triangle("triangle", 2.0, 2.0));
        figuresManager.add(new Square("square", 3.0));
    }

    @Test
    void testTotalArea() {
        assertEquals(61.265, figuresManager.totalArea(), 10e-3);
    }

    @Test
    void testTotalNumberOfSides() {
        assertEquals(Double.POSITIVE_INFINITY, figuresManager.totalNumberOfSides(), 10e-3);
    }

}
