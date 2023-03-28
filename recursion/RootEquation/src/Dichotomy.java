import java.math.BigDecimal;
import java.util.ArrayList;

public class Dichotomy {

    private double start;
    private double finish;

    private ArrayList<Double> results;

    public Dichotomy(double start, double finish) {
        this.start = Math.round(start*1000.0)/1000.0;
        this.finish = Math.round(finish*1000.0)/1000.0;
        results = new ArrayList<>();
        search(start, finish);
        print();
    }

    public double getStart() {
        return start;
    }

    public double getFinish() {
        return finish;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public double func (double x){
        double result = Math.round(Math.cos(Math.pow(x, 5.0)) +
                Math.pow(x, 4.0) - (345.3 * x) - 23*1000.0)/1000.0;
        return result;
    }
    public double search(double start, double finish){

        if (finish-start<=0.001){
         results.add(start);
         return start;
       }

        double mid = start + (finish - start)/2;
       if (func(start)*func(mid) > 0){
           results.add(search(start, mid));
           return search(start, mid);
       } else {
          results.add(search(mid, finish));
          return search(mid, finish);
       }
    }

    public void print(){
        if (results.isEmpty()){
            System.out.println("Dichotomy results: null");
        } else {

            System.out.println("Dichotomy results: ");
            for (double d : results) {
                System.out.println(d + ";");
            }
            System.out.println();

        }
    }

}
