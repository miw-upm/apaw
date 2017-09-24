package es.upm.miw.pd.visitor;

public class ElementA implements Element {
    private String attributeA;

    public ElementA() {
        this.setAttributeA("A");
    }

    public String getAttributeA() {
        return this.attributeA;
    }

    public void setAttributeA(String attributeA) {
        this.attributeA = attributeA;
    }

    @Override
    public void accept(Visitor v) {
        v.visitElementA(this);
    }

}
