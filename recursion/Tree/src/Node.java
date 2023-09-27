public abstract class Node {
    protected int number;

    public Node(int number){
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("node = ").append(getNumber());
        return result.toString();
    }

}
