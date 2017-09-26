package es.upm.miw.pd.visitor;

public class ElementA implements Element {

    private String attributeA;

    public ElementA() {
        attributeA = "A";
    }

    public String getAttributeA() {
        return attributeA;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

}
