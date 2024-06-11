import java.util.ArrayList;

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

    public ArrayList<Integer> getNodesInList() {
        ArrayList<Integer> items = new ArrayList<>();
        inOrderTraversal(root, items);
        return items;
    }

    private void inOrderTraversal(Node root, ArrayList<Integer> items) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft(), items);
        items.add(root.getValue());
        inOrderTraversal(root.getRight(), items);
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
            return currentNode;
        }
        return currentNode;
    }

    public boolean remove(int removeVal) {
        return removeHelper(root, removeVal) != null;
    }

    private Node removeHelper(Node currentNode, int removeVal) {
        if (currentNode == null) {
            return null;
        } else if (removeVal > currentNode.getValue()) {
            currentNode.setRight(removeHelper(currentNode.getRight(), removeVal));
        } else if (removeVal < currentNode.getValue()) {
            currentNode.setLeft(removeHelper(currentNode.getLeft(), removeVal));
        } else {
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            }
            currentNode.setValue(getMinPredecessor(currentNode.getRight()));
            currentNode.setRight(removeHelper(currentNode.getRight(), currentNode.getValue()));
        }
        return currentNode;
    }

    private int getMinPredecessor(Node currentNode) {
        int minVal = currentNode.getValue();
        while (currentNode.getLeft() != null) {
            minVal = currentNode.getValue();
            currentNode = currentNode.getLeft();
        }
        return minVal;
    }

    public boolean contains(int findVal) {
        return findHelper(root, findVal) != null;
    }

    private Node findHelper(Node currentNode, int val) {
        if (currentNode == null) {
            return null;
        } else if (val > currentNode.getValue()) {
            currentNode = findHelper(currentNode.getRight(), val);
        } else if (val < currentNode.getValue()) {
            currentNode = findHelper(currentNode.getLeft(), val);
        } else if (val == currentNode.getValue()) {
            return currentNode;
        }
        return currentNode;
    }
}
