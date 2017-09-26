package es.upm.miw.pd.composite.expression.solution;

public abstract class Operation extends Expression {

    private Expression expression1;

    private Expression expression2;

    public Operation(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    protected abstract String operationString();

    @Override
    public String toString() {
        return "(" + this.getExpression1().toString() + this.operationString() + this.getExpression2().toString() + ")";
    }

}
