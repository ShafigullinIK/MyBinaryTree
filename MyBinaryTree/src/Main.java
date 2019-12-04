public class Main {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(10);
        t.add(7);
        t.add(12);
        t.add(6);
        t.add(11);
        t.add(15);
        t.add(2);
        t.add(4);
        t.treeDelete(t.get(2));
        t.get(2);
        System.out.println(t.min());



    }
}
