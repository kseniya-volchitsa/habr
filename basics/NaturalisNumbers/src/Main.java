import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[99];
        int a = 2;
        for (int i= 0; i < array.length; i++){
            array[i] = a;
            a++;
        }

        print(array);
        ArrayList<Integer> result = naturalis(array);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++){
            resultArray[i] = result.get(i);
        }

        System.out.println();
        System.out.println("Naturalis: ");
        print(resultArray);
    }

    public static ArrayList<Integer> naturalis(int[] array){
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j <=i; j++)
            {
                if (array[i] % j == 0){
                    count++;
                }
            }
            if (count < 2){
                result.add(array[i]);
            }
            count = 0;
        }
        return result;
    }
    public static void print(int[] array){
        int j = 0;
        for (Object i : array){
            System.out.print(i + " ");
            j++;
            if (j % 10 == 0){
                System.out.println();
            }
        }

    }
}