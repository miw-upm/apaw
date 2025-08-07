package es.upm.miw.apaw.pd.visitor;

public class ElementB implements Element {

    private final String attributeB;

    public ElementB() {
        attributeB = "B";
    }

    public String getAttributeB() {
        return attributeB;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

}
