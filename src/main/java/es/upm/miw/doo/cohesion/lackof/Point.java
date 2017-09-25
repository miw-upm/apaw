package es.upm.miw.doo.cohesion.lackof;

public class Point {
    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // error
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // error
    public double module(int x, int y) {
        return Math.sqrt((double)x * x + y * y);
    }

    // error
    public int higher(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    // error
    public void translateOrigin(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double module() {
        return Math.sqrt((double)this.x * this.x + this.y * this.y);
    }

    @Override
    public String toString() {
        return "Point[" + x + "," + y + "]";
    }

}
