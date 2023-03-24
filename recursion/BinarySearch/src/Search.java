public class Search {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public Search(int[] array){
        this.array = array;
    }
    public void sortArray(){
        for (int element : array){
            int a;
            for (int item : array){
                if (element > item){
                    a = element;
                    element = item;
                    item = a;
                }
            }
        }
    }

    public boolean enumerationSearch(int key){
        boolean result = false;
        for (int element : array){
            if(key == element){
                result = true;
                break;
            }
        }
        return result;
    }

    public int binarySearch(int key, int low, int high){
        int middle = (low+high)/2;
        if (high < low){
            return -1;
        }
        if (key < array[middle]){
            return binarySearch(key, low, middle-1);
        }else if (key > array[middle]){
            return binarySearch(key, middle + 1, high);
        } else return middle;
    }


}
