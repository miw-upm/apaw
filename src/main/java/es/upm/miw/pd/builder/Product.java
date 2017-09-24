package es.upm.miw.pd.builder;

public class Product {
    
    private int atrA1;

    private int atrA2;

    private String atrB1;

    private int atrB2;
    
    public Product(int atrA1, int atrA2) {
        this.atrA1 = atrA1;
        this.atrA2 = atrA2;
    }

    public String getAtrB1() {
        return atrB1;
    }

    public void setAtrB1(String atrB1) {
        this.atrB1 = atrB1;
    }

    public int getAtrB2() {
        return atrB2;
    }

    public void setAtrB2(int atrB2) {
        this.atrB2 = atrB2;
    }

    public int getAtrA1() {
        return atrA1;
    }

    public int getAtrA2() {
        return atrA2;
    }

}
