package es.upm.miw.apaw.pd.methodfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiguresManagerTest {

    @Test
    void testCreateFigure() {
        FiguresManager figuresManager = new FiguresManager(FigureType.CIRCLE);
        figuresManager.createFigure();
        assertEquals("Circle", figuresManager.getFigure().getName());
    }
}
