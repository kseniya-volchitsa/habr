public class Pyramid extends Shape{

    private double s;
    private double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
        super(s * h * (1/3));
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

}
