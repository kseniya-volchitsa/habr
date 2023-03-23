import java.math.BigDecimal;
import java.util.Random;

public class Vector {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector (){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public Vector (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length(Vector a){
        BigDecimal resultBD = new BigDecimal(Math.sqrt(a.getX()*a.getX() + a.getY()*a.getY() + a.getZ()*a.getZ()));
        double result = Math.ceil(resultBD.doubleValue());
        return result;
    }

    public double scalarMulti(Vector a, Vector b){
        double result = a.getX()* b.getX() + a.getY()* b.getY() + a.getZ()* b.getZ();
                return result;
    }

    public Vector vectorMulti(Vector a, Vector b){
        double x = a.getY()*b.getZ() - a.getZ()* b.getY();
        double y = a.getZ()*b.getX() - a.getX()*b.getZ();
        double z = a.getX()*b.getY() - a.getY()*b.getX();
        Vector vector = new Vector(x, y, z);
        return vector;
    }

    public double cosinus(Vector a, Vector b){
        double result = (scalarMulti(a, b)) / (Math.abs(length(a))*Math.abs(length(b)));
        return result;
    }

    public Vector sum(Vector a, Vector b){
        Vector result = new Vector(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
        return result;
    }

    public Vector minus(Vector a, Vector b){
        Vector result = new Vector(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
        return result;
    }

    public Vector[] randomVectors(int length){
        int size = -1;
        Random random = new Random();
        while (size <= 0) {
            size = (int) (random.nextInt(16));
            System.out.println("randomVectorsize: " + size);
        }
        Vector[] array = new Vector[size];
        int forXSize = size - (int) (random.nextInt(16));
        if (forXSize > 0) {
            for (int i = 0; i < forXSize; i++)
                array[i] = randomVectorX(length);
            } else {
            forXSize = 0;
        }
        System.out.println("Xsize: " + forXSize);

        int forYSize = size - (int) (random.nextInt(16))-forXSize;
        if (forYSize > 0){
            for (int i = forXSize; i < forXSize + forYSize; i++){
                array[i] = randomVectorY(length);
            }
        } else {
            forYSize = 0;
        }
        System.out.println("Ysize: " + forYSize);

        int forZSize = size - forXSize - forYSize;
        if (forZSize > 0){
            for (int i = forXSize + forYSize; i < forXSize + forYSize + forZSize; i++){
                array[i] = randomVectorZ(length);
            }
        }
        System.out.println("Zsize: " + forZSize);
        return array;
    }

    public Vector randomVectorX(int length){
        double length2 = (double) length*length;
       Random random = new Random();
            double x2 = -1.0d;
            double y = 0;
            double z = 0;
            while (x2 < 0){
                y = Math.ceil(random.nextDouble(length));
                double y2 = y*y;
                z = Math.ceil(random.nextDouble(length));
                double z2 = z*z;
                BigDecimal l2BD = new BigDecimal(length2);
                BigDecimal y2BD = new BigDecimal(y2);
                BigDecimal z2BD = new BigDecimal(z2);
                BigDecimal resultX2 = l2BD.subtract(y2BD);
                resultX2 = resultX2.subtract(z2BD);
                x2 = Math.ceil(resultX2.doubleValue());
            }
            double x = Math.ceil(Math.sqrt(x2));
            Vector result = new Vector(x, y, z);
            System.out.println("Length = " + length(result));
        return result;
        }

    public Vector randomVectorY(int length){
        double length2 = (double)length*length;
        Random random = new Random();
            double y2 = -1.0d;
            double x = 0;
            double z = 0;
            while (y2 < 0){
                x = Math.ceil(random.nextDouble(length));
                double x2 = x*x;
                z = Math.ceil(random.nextDouble(length));
                double z2 = z*z;
                BigDecimal l2BD = new BigDecimal(length2);
                BigDecimal x2BD = new BigDecimal(x2);
                BigDecimal z2BD = new BigDecimal(z2);
                BigDecimal resultY2 = l2BD.subtract(x2BD);
                resultY2 = resultY2.subtract(z2BD);
                y2 = Math.ceil(resultY2.doubleValue());
            }
            double y = Math.ceil(Math.sqrt(y2));
        Vector result = new Vector(x, y, z);
        System.out.println("Length = " + length(result));
        return result;
    }

    public Vector randomVectorZ(int length){
        double length2 = (double) length*length;
        Random random = new Random();
            double z2 = -1.0d;
            double x = 0;
            double y = 0;
            while (z2 < 0){
                x = Math.ceil(random.nextDouble(length));
                double x2 = x*x;
                y = Math.ceil(random.nextDouble(length));
                double y2 = y*y;
                BigDecimal l2BD = new BigDecimal(length2);
                BigDecimal x2BD = new BigDecimal(x2);
                BigDecimal y2BD = new BigDecimal(y2);
                BigDecimal resultZ2 = l2BD.subtract(x2BD);
                resultZ2.subtract(y2BD);
                z2 = Math.ceil(resultZ2.doubleValue());
            }
            double z = Math.ceil(Math.sqrt(z2));
        Vector result = new Vector(x, y, z);
        System.out.println("Length = " + length(result));
        return result;
        }

    public void printArrayVector(Vector[] array){
        int i = 0;
        for (Vector item : array){
            if (item == null){
                System.out.println("Vector " + i + "(null)");
            }
            System.out.println("Vector " + i + "(" + item.getX() + ", " + item.getY() + ", " +
                    item.getZ() + ")");
            i++;
        }
    }


}
