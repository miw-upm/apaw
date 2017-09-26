package es.upm.miw.pd.visitor;

public class ElementB implements Element {

    private String attributeB;

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
