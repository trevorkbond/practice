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

    public boolean add(int addVal) {
        if (addHelper(addVal, root) != null) {
            return true;
        } else {
            return false;
        }
    }

    private Node addHelper(int addVal, Node currentNode) {
        if (currentNode == null) {
            currentNode = new Node(addVal);
            if (root == null && size == 0) {
                root = currentNode;
            }
            size++;
            return currentNode;
        } else if (addVal < currentNode.getValue()) {
            currentNode.setLeft(addHelper(addVal, currentNode.getLeft()));
        } else if (addVal > currentNode.getValue()) {
            currentNode.setRight(addHelper(addVal, currentNode.getRight()));
        } else if (addVal == currentNode.getValue()) {
            return null;
        }
        return currentNode;
    }

    public boolean remove(int removeVal) {
        return false;
    }

    public boolean contains(int findVal) {
        return false;
    }
}
