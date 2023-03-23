public class Main {
    public static void main(String[] args) {

        String[] strings = new String[]{"a","b","c"};
        int[] number = new int[]{1,2,10};
    ReturnRandomElement ret1 = new ReturnRandomElement(strings, number);
    for (int i = 0; i < 13; i++){
        System.out.println(ret1.randomElement());
    }
    }
}