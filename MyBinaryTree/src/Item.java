public class Item {

    private int value;
    private Item left;
    private Item right;

    public void setParent(Item parent) {
        this.parent = parent;
    }

    private Item parent;

    public Item(int value) {
        this(value, null);
    }

    public Item(int value, Item parent) {
        this.value = value;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public Item getLeft() {
        return left;
    }

    public Item getRight() {
        return right;
    }

    public Item getParent() {
        return parent;
    }

    public void setLeft(Item left) {
        this.left = left;
    }

    public void setRight(Item right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return value+"";
    }
}
