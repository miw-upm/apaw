package es.upm.miw.pd.visitor;

public class Visitor2 implements Visitor {

    private int as = 0;

    private int bs = 0;

    protected int getAs() {
        return as;
    }

    protected int getBs() {
        return bs;
    }

    @Override
    public void visitElementA(ElementA e) {
        as++;
    }

    @Override
    public void visitElementB(ElementB e) {
        bs++;
    }

    @Override
    public String toString() {
        return "As:" + as + ", Bs:" + bs;
    }

}
