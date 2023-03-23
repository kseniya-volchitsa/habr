import java.util.Random;

public class ReturnRandomElement {

    private char[] values;
    private int[] priorities;

    private int sum;
    private int[] weights;


    public ReturnRandomElement(char[] values, int[] priorities){
        this.values = values;
        this.priorities = priorities;
        sum = 0;
        weights = new int[priorities.length];
        int j = 0;
        for (int i : priorities){
            sum += i;
            weights[j] = sum-1;
            j++;
        }
    }

    public Object randomElement(){
        Object result = null;
        Random random = new Random();
        int i = random.nextInt(sum);
        System.out.print(i);
        for (int j = 0; j < weights.length; j++){
            if (i == weights[j]){
                result = values[j];
                break;
            } else if (i < weights[j]){
                result = values[j];
                break;
            }
        }

        return result;
    }
}
