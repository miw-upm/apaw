package es.upm.miw.pd.composite.expression.solution;

public class Summation extends Operation {

    public Summation(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public int operate() {
        return this.getExpression1().operate() + this.getExpression2().operate();
    }

    @Override
    protected String operationString() {
        return "+";
    }

}
