package es.upm.miw.doo.cohesion.lackof;

//No cumple el: Single Responsibility Principle
public class Mathematics {
    private int x;
    private int y;
    private int z;

    private double angle;

    private int numerador;
    private int denominador;

    public Mathematics(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Mathematics(double angle) {
        this.angle = angle;
    }

    public Mathematics(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public double module() {
        return Math.sqrt((double)this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public void addAngle(int angle) {
        this.angle += this.angle + angle;
        this.angle %= (360);
    }

    public double decima() {
        return (double) numerador / denominador;
    }
}
