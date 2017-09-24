package es.upm.miw.pd.flyweight;

public class FlyweightConcrete {
    private String intrinsic;

    public FlyweightConcrete(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    public String getIntrinseco() {
        return this.intrinsic;
    }

    public String operation(String extrinsic) {
       return extrinsic + this.intrinsic + extrinsic;
    }
}
