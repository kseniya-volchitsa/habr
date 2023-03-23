import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        double [] array = new double[n];
        double c;
        for (int i = 0; i < n; i++){
            c = (double) (1000 * Math.random());
            array[i] = Math.round(c * 100.0d)/100.0d;
        }

        double min = 10;
        double max = -1.0;
        double avg;
        double res = 0;
        for (int i = 0; i < n; i++){
            if (min > array[i]){
                min = array[i];
            }
            if (max < array[i]){
                max = array[i];
            }
            res += array[i] / array.length;
        }
        avg = Math.round(res * 100.0d)/100.0d;

      /*  ArrayList <Double> list = new ArrayList<Double>();
        for (double e : array){
            list.add(e);
        }
         Collections.sort(list);
        avg = list.get(49);
        */

        System.out.println("Минимальное: " + min);
        System.out.println("Максимальное: " + max);
        System.out.println("Среднее: " + avg);
    }
}