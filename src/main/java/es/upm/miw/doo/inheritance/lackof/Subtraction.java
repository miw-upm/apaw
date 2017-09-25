package es.upm.miw.doo.inheritance.lackof;

public class Subtraction {
    private final int operator1, operator2;

    public Subtraction(final int operator1, final int operator2) {
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    public int getOperator1() {
        return operator1;
    }

    public int getOperator2() {
        return operator2;
    }

    public int subtract() {
        return this.operator1 - this.operator2;
    }

    @Override
    public String toString() {
        return "[" + operator1 + "-" + operator2 + "]";
    }

}
