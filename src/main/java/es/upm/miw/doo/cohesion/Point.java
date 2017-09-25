package es.upm.miw.doo.cohesion;

public class Point {
    private int x;
    
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
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

    public double phase() {
        return Math.atan((double) this.y / this.x);
    }

    public void translateOrigin(Point origin) {
        this.x -= origin.getX();
        this.y -= origin.getY();
    }

    @Override
    public String toString() {
        return "Point[" + x + "," + y + "]";
    }
    
}
