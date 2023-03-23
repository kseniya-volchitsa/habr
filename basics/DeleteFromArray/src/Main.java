import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        System.out.println("Исходный массив: ");
        int[] array = newArray();
        printArray(array);
        System.out.println("Введите число, которое нужно удалить из массива: ");
        Scanner line = new Scanner(System.in);
        String text = line.nextLine();
        int number = Integer.parseInt(text);
        int[] result = arrayWithoutNumber(array, number, countNumber(array, number));
        System.out.println("Итоговый массив: ");
        printArray(result);

    }

    public static int countNumber (int[] array, int number){
        int count = 0;
        for (int i : array){
            if (i == number){
                count++;
            }
        }
        return count;
    }

    public static int[] arrayWithoutNumber(int[] array, int number, int count){
        int[] result = new int[array.length - count];
        int i = 0;
        int j = 0;
        while (i < result.length) {
            if (array[j] != number) {
                result[i] = array[j];
                j++;
                i++;
            } else {
            j++;
            }
        }
        return result;
    }
    public static int[] newArray (){
        int size = (int) (100 * Math.random());
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (100 * Math.random());
        }
        return array;
    }

    public static void printArray (int[] array){
        int j = 0;
        for(int i : array){
            System.out.print(i + " ");
            j++;
            if (j % 10 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

}