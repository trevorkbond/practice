public class BinaryTree {
    private Node root;
    private int size;
    public BinaryTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public boolean add(int insertVal) {
        root = new Node(insertVal);
        size++;
        return true;
    }

    public boolean remove(int removeVal) {
        return false;
    }

    public boolean contains(int findVal) {
        return false;
    }
}
