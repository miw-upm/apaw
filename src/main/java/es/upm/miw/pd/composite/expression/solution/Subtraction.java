package es.upm.miw.pd.composite.expression.solution;

public class Subtraction extends Operation {

    public Subtraction(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public int operate() {
        return this.getExpression1().operate() - this.getExpression2().operate();
    }

    @Override
    protected String operationString() {
        return "-";
    }

}
