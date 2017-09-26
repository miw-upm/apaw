package es.upm.miw.pd.composite.expression.solution;

public class Number extends Expression {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int operate() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}
