import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private List<Node> list;
    private int size;
    private Node first;
    private Node last;

    public List<Node> getList() {
        return list;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

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
        size = list.size();
    }

    
    public Node get(int index){
        Node result;
        if (index > list.size()){
            System.out.println("Слишком большой индекс");
            result = null;
        } else result = list.get(index);
        return result;
    }

    public void removeIndex (int index){
        Node removed = list.get(index);
        Node prev = removed.getPrev();
        Node next = removed.getNext();
        if (prev == null){
            first = next;
        } else {
            prev.setNext(next);
        }
        if (next == null){
            last = prev;
        } else {
            next.setPrev(prev);
        }
        list.remove(index);
        size = list.size();
    }

    public void addFirst (Object obj){
        Node newFirst = new Node(obj, first, null);
        first.setPrev(newFirst);
        list.add(0, newFirst);
        first = newFirst;
        size = list.size();
    }

    public void addLast (Object obj){
        Node newLast = new Node(obj, null, last);
        last.setNext(newLast);
        list.add(newLast);
        last = newLast;
        size = list.size();
    }

    public void removeLast(){
        Node removed = last;
        Node prev = last.getPrev();
        prev.setNext(null);
        last = prev;
        list.remove(list.size()-1);
        size = list.size();
    }

    public void removeFirst(){
        Node removed = first;
        Node next = first.getNext();
        next.setPrev(null);
        first = next;
        list.remove(0);
        size = list.size();
    }






}
