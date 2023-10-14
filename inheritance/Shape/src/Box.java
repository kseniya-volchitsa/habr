import java.util.ArrayList;

public class Box extends Shape{
 private ArrayList <Shape> shapes = new ArrayList<>();
 private double availableVolume;

    public Box(double availableVolume) {
        super(availableVolume);
        this.availableVolume = availableVolume;
    }


    public boolean add(Shape shape){
        if (shape.getVolume() >= availableVolume){
            shapes.add(shape);
            return true;
        } else return false;
    }
}
