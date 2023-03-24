import java.util.Random;

public class Main {
    public static void main(String[] args) {
    int[] array = randomArray();
    int key = randomKey();
    Search search = new Search(array);

        System.out.println("Random array: ");
    int j = 1;
        for (int i : array){
            System.out.print(i + "; ");
            if (j%10==0) System.out.println();
            j++;
        }
        System.out.println();
    search.sortArray();
    array = search.getArray();
        System.out.println("Random sort array: ");
        int m = 1;
        for (int i : array){
            System.out.print(i + "; ");
            if (j%10==0) System.out.println();
            m++;
        }
        System.out.println("Key: " + key);
        long time = System.currentTimeMillis();
        System.out.println("Enumaration search result: " + search.enumerationSearch(key));
        System.out.println(System.currentTimeMillis() - time);
        System.out.println();

        time = System.currentTimeMillis();
        System.out.println("Binary search result: " + search.binarySearch(key, 0, array.length-1));
        System.out.println(System.currentTimeMillis() - time);


    }

    public static int randomKey(){
        Random random = new Random();
        int key = random.nextInt(20)+1;
        return key;
    }
    public static int[] randomArray(){
        Random random = new Random();
        int size = random.nextInt(20)+1;
        int[] array = new int[size];
        for (int item: array){
            item = random.nextInt();
        }
        return array;
    }
}