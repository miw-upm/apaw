package es.upm.miw.pd.composite.expression.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {
    private Expression exp1, exp2, exp3, exp4, exp5, exp6;

    @BeforeEach
    void before() {
        this.exp1 = new Number(4);
        this.exp2 = new Summation(this.exp1, new Number(2));
        this.exp3 = new Subtraction(this.exp1, new Number(3));
        this.exp4 = new Multiplication(this.exp1, new Number(2));
        this.exp5 = new Division(this.exp1, new Number(3));
        this.exp6 = new Summation(
                new Subtraction(
                        new Number(3),
                        new Multiplication(
                                new Division(this.exp1, new Number(2)),
                                new Number(3)
                        )
                ),
                this.exp1
        );// ((3-((4/2)*3))+4)
    }

    @Test
    void testNumber() {
        assertEquals(4, this.exp1.operate());
    }

    @Test
    void TestSummation() {
        assertEquals(6, this.exp2.operate());
    }

    @Test
    void testSubtraction() {
        assertEquals(1, this.exp3.operate());
    }

    @Test
    void testMultiplication() {
        assertEquals(8, this.exp4.operate());
    }

    @Test
    void testDivision() {
        assertEquals(1, this.exp5.operate());
    }

    @Test
    void testExpressionComposite() {
        assertEquals(1, this.exp6.operate());
    }

    @Test
    void testToString() {
        assertEquals("((3-((4/2)*3))+4)", this.exp6.toString());
    }
}
