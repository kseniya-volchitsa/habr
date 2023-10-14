public class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height) {
        super(Math.pow(radius, 2) * Math.PI * height, radius);
        this.height = height;
    }


}
