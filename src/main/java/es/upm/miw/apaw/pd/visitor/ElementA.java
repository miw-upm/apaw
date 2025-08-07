package es.upm.miw.apaw.pd.visitor;

public class ElementA implements Element {

    private final String attributeA;

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
