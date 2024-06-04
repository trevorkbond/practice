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
        return addHelper(addVal, root) != null;
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

    private Node findRemoveHelper(Node currentNode, int val, boolean isRemove) {
        if (currentNode == null) {
            return null;
        } else if (val > currentNode.getValue()) {
            currentNode = findRemoveHelper(currentNode.getRight(), val, isRemove);
        } else if (val < currentNode.getValue()) {
            currentNode = findRemoveHelper(currentNode.getLeft(), val, isRemove);
        } else if (val == currentNode.getValue()) {
            //FIXME: implement deleting node if isRemove is true
            if (!isRemove) {
                return currentNode;
            }
        }
        return currentNode;
    }

    public boolean contains(int findVal) {
        return findRemoveHelper(root, findVal, false) != null;
    }
}
