public class BSTreeLeaf extends Node {

    private BSTreeLeaf parent;
    private BSTreeLeaf left;
    private BSTreeLeaf right;


    public BSTreeLeaf(int number) {
        super(number);
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BSTreeLeaf(int number, BSTreeLeaf parent) {
        super(number);
        this.parent = parent;
        this.left = null;
        this.right = null;
    }



    public BSTreeLeaf(int number, BSTreeLeaf parent, BSTreeLeaf left, BSTreeLeaf right) {
        super(number);
        this.parent = parent;
        this.left = left;
        this.right = right;
    }



    public BSTreeLeaf getParent() {
        return parent;
    }

    public void setParent(BSTreeLeaf parent) {
        this.parent = parent;
    }

    public BSTreeLeaf getLeft() {
        return left;
    }

    public void setLeft(BSTreeLeaf left) {
        this.left = left;
    }

    public BSTreeLeaf getRight() {
        return right;
    }

    public void setRight(BSTreeLeaf right) {
        this.right = right;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append(", parent = ");
        if (getParent() != null){
            result.append(getParent().getNumber()).append(", right = ");
        } else result.append("null").append(", right = ");
        if (getRight() != null) {
            result.append(getRight().getNumber()).append(", left = ");
        } else result.append("null").append(", left = ");
        if (getLeft() != null) {
            result.append(getLeft().getNumber()).append("\n");
        } else result.append("null").append("\n");
        return result.toString();
    }



}
