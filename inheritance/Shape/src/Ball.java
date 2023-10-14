public class Ball extends SolidOfRevolution{

    public Ball(double radius) {
        super(Math.pow(radius, 3) * Math.PI * (4 / 3), radius);
    }

}
