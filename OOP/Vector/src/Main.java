public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector();
        Vector[] array = vector.randomVectors(1000);
        vector.printArrayVector(array);
    }
}