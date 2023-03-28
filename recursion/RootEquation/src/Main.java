public class Main {
    public static void main(String[] args) {


        long time = System.currentTimeMillis();
        Dichotomy dichotomy = new Dichotomy(0,10);
        System.out.println("Time for dichotomy: " + (System.currentTimeMillis() - time));
    }
}