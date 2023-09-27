import java.util.ArrayList;

public class BSTree {

    protected ArrayList<Node> tree;
    protected BSTreeLeaf root;

    public BSTree(){
        this.root = null;
        tree = new ArrayList<>();
        System.out.println("Конструктор без параметров");
    }
    public BSTree(int leaf){
        tree = new ArrayList<>();
        this.root = new BSTreeLeaf(leaf);
        tree.add(root);
        System.out.println("Создание дерева с корнем " + root);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(BSTreeLeaf root) {
        tree.remove(root);
        this.root = root;
        tree.add(root);
    }

    public void add(int leaf){
        for (Node node : tree){
            if (node.getNumber() == leaf){
                System.out.println("Такое значение уже есть в дереве. Предложите новое.");
                return;
            }
        }
            searchLeafPlace(root, leaf);
    }

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void setTree(ArrayList<Node> tree) {
        this.tree = tree;
    }

    public void searchLeafPlace(BSTreeLeaf node, int leaf){
        if (node.getNumber() < leaf) {
            if (node.getRight() != null) searchLeafPlace(node.getRight(), leaf);
            else {
                BSTreeLeaf right = new BSTreeLeaf (leaf, node);
                node.setRight(right);
                tree.add(right);
                System.out.println("Лист добавлен. Parent = " + right.getParent().getNumber() +
                        ", right = " + right.getNumber());
            }
        }
        else if (node.getNumber() > leaf) {
            if (node.getLeft() != null) {
                searchLeafPlace(node.getLeft(), leaf);
            } else {
                BSTreeLeaf left = new BSTreeLeaf(leaf, node);
                node.setLeft(left);
                tree.add(left);
                System.out.println("Лист добавлен. Parent = " + left.getParent().getNumber() +
                        ", left = " + left.getNumber());
            }
        }
    }

    public boolean searchNodeBoolean(int leaf){
        boolean result = searchBoolean(root, leaf);
        return result;
    }

    public BSTreeLeaf searchNodeValue(int leaf){
        BSTreeLeaf result = SearchObject(root, leaf);
        return result;
    }

    public BSTreeLeaf SearchObject(BSTreeLeaf node, int leaf){
        BSTreeLeaf result = null;
        if (node.getNumber() > leaf && node.getLeft()!= null){
            SearchObject(node.getLeft(), leaf);
        }
        else if (node.getNumber() < leaf && node.getRight()!= null){
            SearchObject(node.getRight(), leaf);
        }
        else if (node.getNumber() == leaf){
            System.out.println("Элемент найден:\n" + node);
            result = node;
        }
        else if ((node.getNumber() > leaf && node.getLeft()== null)
                || (node.getNumber() < leaf && node.getRight()== null)){
            System.out.println("Такого значения в дереве нет.");
        }
        return result;
    }
    public boolean searchBoolean(BSTreeLeaf node, int leaf){
        boolean result = false;
        if (node.getNumber() > leaf && node.getLeft()!= null){
            searchBoolean(node.getLeft(), leaf);
        }
        else if (node.getNumber() < leaf && node.getRight()!= null){
            searchBoolean(node.getRight(), leaf);
        }
        else if (node.getNumber() == leaf){
            System.out.println("Элемент найден:\n" + node);
            result = true;
        }
        else if ((node.getNumber() > leaf && node.getLeft()== null)
                || (node.getNumber() < leaf && node.getRight()== null)){
            System.out.println("Такого значения в дереве нет.");
        }
        return result;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (Node node : tree){
            result.append(count++).append(". ").append(node);
        }
        return result.toString();
    }

    public void removeByValue(int leaf){
        BSTreeLeaf node = searchNodeValue(leaf);
        removeByObject(node);

    }

    public void removeByObject(BSTreeLeaf node){
        if (node == root){
            newRoot();
        }
        else if(node.getLeft() == null && node.getRight() != null)
        {
            addOneChild(node.getRight(), node);
        }
        else if (node.getRight() == null && node.getLeft() != null){
            addOneChild(node.getLeft(), node.getParent());
        }
        else if (node.getRight() != null && node.getLeft() != null){
            int nodesForAdding[] = new int[]{};
            addTwoChildren(node, node.getParent(), node.getRight(), node.getLeft(), nodesForAdding[]);
        }
        else if (node.getRight() == null && node.getLeft() != null){
            tree.remove(node);
            if (node.getParent().getLeft() == node){
            node.getParent().setLeft(null);
            }
            else if (node.getParent().getRight() == node){
                node.getParent().setRight(null);
            }
        }
    }


    public void addOneChild(BSTreeLeaf node, BSTreeLeaf parent){
        tree.remove(node);
        if (node.getLeft() != null){
            parent.setLeft(node.getLeft());
            node.getLeft().setParent(parent);
            System.out.println("Теперь node = " + node.getLeft().getNumber()
                    + " - левое дитё parent = " + parent.getNumber());
        }
        else if (node.getRight() != null){
            parent.setRight(node.getRight());
            node.getRight().setParent(parent);
            System.out.println("Теперь node = " + node.getRight().getNumber()
                    + " - правое дитё parent = " + parent.getNumber());
        }
    }

    public void addTwoChildren(BSTreeLeaf node, BSTreeLeaf parent, BSTreeLeaf right, BSTreeLeaf left, int arrayNodes[]){

        /*int rightLeaf = right.getNumber();
        int leftLeaf = left.getNumber();
        searchLeafPlace(parent, leftLeaf);
        searchLeafPlace(parent, rightLeaf);
        if (right.getLeft() != null && right.getRight() != null){
            tree.remove(right.getRight());
            tree.remove(right.getLeft());
            right.setLeft(null);
            right.setRight(null);
            addTwoChildren(right, right.getRight(), right.getLeft());
        }
        if (right.getLeft() != null && right.getRight() == null){
            tree.remove(right.getLeft());
            addOneChild(right.getLeft(), right);
        }
        if (right.getLeft() == null && right.getRight() != null){
            tree.remove(right.getRight());
            addOneChild(right.getRight(), right);
        }
        if(left.getLeft() != null && left.getRight() != null){
            tree.remove(left.getRight());
            tree.remove(left.getLeft());
            left.setLeft(null);
            left.setRight(null);
            addTwoChildren(left, left.getRight(), left.getLeft());
        }
        if(left.getLeft() != null && left.getRight() == null){
            tree.remove(left.getLeft());
            addOneChild(left.getLeft(), left);
        }
        if(left.getLeft() == null && left.getRight() != null){
            tree.remove(left.getRight());
            addOneChild(left.getRight(), left);
        }*/

    }

    public void newRoot(){
        tree.remove(root);
        BSTree resultTree = new BSTree();
        int center = tree.size()/2;
        int leafNewRoot = tree.get(center).getNumber();
        resultTree.add(leafNewRoot);
        for (Node node : tree){
            resultTree.add(node.getNumber());
        }
        this.setTree(resultTree.getTree());
        System.out.println("Новое дерево после изменения корня: " + this);
    }

}
