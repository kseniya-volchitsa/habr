import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private List<Node> list;
    private int size;
    private Node first;
    private Node last;
    public LinkedList(){
        size = 0;
        list = new ArrayList<Node>();
        first = null;
        last = null;
    }

    public void add(Object obj){
        if(size == 0){
            Node node = new Node(obj, null, null);
            Node first = node;
            Node last = node;
            list.add(node);
        } else if (size == 1){
            Node node = new Node(obj, null, first);
            first.setNext(node);
            Node last = node;
            list.add(node);
        } else {
            Node node = new Node(obj, null, last);
            last.setNext(node);
            Node last = node;
            list.add(node);
        }
    }

    
    public Node get(int index){
        Node result;
        if (index > list.size()){
            System.out.println("Слишком болшьшой индекс");
            result = null;
        } else result = list.get(index);
        return result;
    }





}
