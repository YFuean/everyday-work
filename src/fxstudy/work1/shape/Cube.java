package fxstudy.work1.shape;

public class Cube extends Rectangle {
    private double h;

    public Cube(){
        super();
    }

    public Cube(double h) {
        this.h = h;
    }

    public Cube(double x, double y, double h) {
        super(x, y);
        this.h = h;
    }

    public void show(){
        System.out.print("立方体的体积是：");
    }

    public double getArea(){
        return this.h*this.x*this.y;

    }
}
