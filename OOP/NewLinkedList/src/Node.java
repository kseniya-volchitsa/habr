public class Node {
    private Object obj;
    private Node next;
    private Node prev;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getObj() {
        return obj;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node(Object obj, Node next, Node prev){
        this.obj = obj;
        this.next = next;
        this.prev = prev;
    }
}
