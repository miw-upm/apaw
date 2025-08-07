package es.upm.miw.apaw.pd.flyweight;

public class FlyweightConcrete {
    private final String intrinsic;

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
