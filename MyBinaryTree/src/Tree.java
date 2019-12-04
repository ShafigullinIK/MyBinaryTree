public class Tree {


    private Item root;
    private boolean isEmpty = true;

    public Tree() {

    }

    public boolean add(int value) {
        if (isEmpty) {
            root = new Item(value);
            isEmpty = false;
            return true;
        }
        return add(value, root);
    }

    public boolean add(int value, Item item) {
        if (value < item.getValue()) {
            if (item.getLeft() == null) {
                item.setLeft(new Item(value, item));
                return true;
            }
            return add(value, item.getLeft());
        }
        if (value > item.getValue()) {
            if (item.getRight() == null) {
                item.setRight(new Item(value, item));
                return true;
            }
            return add(value, item.getRight());
        } else {
            return false;
        }
    }

    private Item min(Item item) {
        Item result = item;
        while (result.getLeft() != null) {
            result = result.getLeft();
        }
        return result;
    }

    public Item min() {
        if (isEmpty) {
            throw new MyTreeIsEmptyException("isEmpty = " + isEmpty);
        }
        return min(root);
    }

    public Item max() {
        Item result = root;
        if (isEmpty) {
            throw new MyTreeIsEmptyException("isEmpty = " + isEmpty);
        }
        while (result.getRight() != null) {
            result = result.getRight();
        }
        return result;
    }

    public Item successor(int value) {
        return successor(get(value));
    }

    public Item successor(Item item) {
        if (item.getRight() != null) {
            return min(item.getRight());
        }
//        Item y = item.getParent();
//        while(y != null && item == y.getRight()){
//            item = y;
//            y = y.getParent();
//        }
//        return y;


        int currentValue = item.getValue();
        while (item.getParent() != null &&
                item != item.getParent().getLeft()) {
            item = item.getParent();
        }
        if (currentValue > item.getParent().getValue()) {
            throw new MyTreeElementNotFoundException("Successor not found");
        } else {
            return item.getParent();
        }
    }

    public Item get(int value) {
        if (isEmpty) {
            throw new MyTreeIsEmptyException("isEmpty = " + isEmpty);
        }
        return get(value, root);
    }

    public Item get(int value, Item item) {
        if (item == null) {
            throw new MyTreeElementNotFoundException();
        }
        if (value == item.getValue()) {
            return item;
        }
        if (value > item.getValue()) {
            return get(value, item.getRight());
        } else {
            return get(value, item.getLeft());
        }
    }

    public boolean contains(int value) {
        try {
            get(value);
        } catch (MyTreeElementNotFoundException e) {
            return false;
        }
        return true;
    }

    private void transplant(Item u, Item v) {
        if (u.getParent() == null) {
            root = v;
        } else {
            if (u == u.getParent().getLeft()) {
                u.getParent().setLeft(v);
            } else {
                u.getParent().setRight(v);
            }
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    public void treeDelete(Item z) {
        if (z.getLeft() == null) {
            transplant(z, z.getRight());
        } else {
            if (z.getRight() == null) {
                transplant(z, z.getLeft());
            } else {
                Item y = min(z.getRight());
                if(y.getParent() != z){
                    transplant(y, y.getRight());
                    y.setRight(z.getRight());
                    y.getRight().setParent(y);
                }
                transplant(z,y);
                y.setLeft(z.getLeft());
                y.getLeft().setParent(y);
            }
        }
    }


}




