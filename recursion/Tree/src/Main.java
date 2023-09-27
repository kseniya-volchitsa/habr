public class Main {
    public static void main(String[] args) {
        BSTree tree = new BSTree(100);
        tree.add(15);
        System.out.println("tree size = " + tree.getTree().size());
        tree.add(15);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        tree.add(101);
        tree.add(500);
        tree.add(666);
        tree.add(1500);
        tree.add(1);
        tree.add(99);
        System.out.println("Tree:\n" + tree);
        System.out.println("Поиск 15");
        tree.searchNodeBoolean(15);
        System.out.println("Поиск 10");
        tree.searchNodeBoolean(10);
        System.out.println("Поиск 1500");
        tree.searchNodeBoolean(1500);
        System.out.println("Поиск 600");
        tree.searchNodeBoolean(600);


    }
}