import java.util.Random;

public class Main {
    public static void main(String[] args) {

       /* String[] strings = new String[]{"a","b","c"};
        int[] number = new int[]{1,2,10};
    ReturnRandomElement ret1 = new ReturnRandomElement(strings, number);
    for (int i = 0; i < 13; i++){
        System.out.println(ret1.randomElement());
    }*/

        Object[] objects =twoRandomArrays();
        char[] values = (char[]) objects[0];
        int[] numbers = (int[]) objects[1];
        ReturnRandomElement ret2 = new ReturnRandomElement(values, numbers);
        System.out.println("Arrays:");
        for (int i = 0; i < numbers.length; i++ ){
            System.out.print(numbers[i] + "- " + values[i] + "; ");
            if(i>0 && i%10==0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Randoms:");
        for (int i = 0; i < numbers.length*5; i++){
            System.out.print(ret2.randomElement() + "; ");
            if(i>0 && i%10==0){
                System.out.println();
            }
        }
    }

    public static Object[] twoRandomArrays(){
        Object[] result = new Object[2];
        Random random = new Random();
        int size = random.nextInt(20);
        char[] chars = new char[size];
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++){
            chars[i] = (char)(random.nextInt(256));
            numbers[i] = random.nextInt(10);
        }
        result[0] = chars;
        result[1] = numbers;
        return result;
    }
}