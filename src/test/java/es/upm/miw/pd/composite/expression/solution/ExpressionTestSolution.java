package es.upm.miw.pd.composite.expression.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.pd.composite.expression.solution.Division;
import es.upm.miw.pd.composite.expression.solution.Expression;
import es.upm.miw.pd.composite.expression.solution.Multiplication;
import es.upm.miw.pd.composite.expression.solution.Number;
import es.upm.miw.pd.composite.expression.solution.Subtraction;
import es.upm.miw.pd.composite.expression.solution.Summation;

public class ExpressionTestSolution {
    private Expression expression1, expression2, expression3, expression4, expression5, expression6;

    @Before
    public void ini() {
        this.expression1 = new Number(4);
        this.expression2 = new Summation(this.expression1, new Number(2));
        this.expression3 = new Subtraction(this.expression1, new Number(3)); 
        this.expression4 = new Multiplication(this.expression1, new Number(2));
        this.expression5 = new Division(this.expression1, new Number(3));
        this.expression6 = new Summation(new Subtraction(new Number(3), new Multiplication(
                new Division(this.expression1, new Number(2)), new Number(3))), this.expression1); // ((3-((4/2)*3))+4)
    }

    @Test
    public void testNumber() {
        assertEquals(4, this.expression1.operate());
    }

    @Test
    public void TestSummation() {
        assertEquals(6, this.expression2.operate());
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, this.expression3.operate());
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(8, this.expression4.operate());
    }

    @Test
    public void testDivision() {
        assertEquals(1, this.expression5.operate());
    }

    @Test
    public void testExpression() {
        assertEquals(1, this.expression6.operate());
    }

    @Test
    public void testToString() {
        assertEquals("((3-((4/2)*3))+4)", this.expression6.toString());
    }
}
