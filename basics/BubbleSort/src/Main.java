public class Main {
    public static void main(String[] args) {

    int[] array = new int[100];
    for (int i = 0; i < array.length; i++){
        array[i] = (int)(1000*Math.random());
    }

    array = bubbleSort(array);
    print(array);
    }

    public static int[] bubbleSort(int array[]){
        int[] result = array;
        int merge;
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result.length; j++){
                if (result[i] < result[j]){
                    merge = result[i];
                    result[i] = result[j];
                    result[j] = merge;
                }
            }
        }
        return result;
    }

    public static void print(int array[]){
        int j = 0;
        for (int i : array){
            System.out.print(i + " ");
        j++;
        if (j % 10 == 0){
            System.out.println();
        }
        }
    }


}