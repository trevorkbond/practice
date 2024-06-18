import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
            System.out.printf("Added node with val %d, height is %d\n", currentNode.getValue(), currentNode.getHeight());
            return currentNode;
        } else if (addVal < currentNode.getValue()) {
            currentNode.setLeft(addHelper(addVal, currentNode.getLeft()));
        } else if (addVal > currentNode.getValue()) {
            currentNode.setRight(addHelper(addVal, currentNode.getRight()));
        } else if (addVal == currentNode.getValue()) {
            return currentNode;
        }
        currentNode.updateHeight();
        System.out.printf("Node with val %d has height of %d\n", currentNode.getValue(), currentNode.getHeight());
        System.out.println(currentNode.getImbalanceType());
        return currentNode;
    }

    @Override
    public String toString() {

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        StringBuilder builder = new StringBuilder();

        int numAdded = 0;
        int numSkipped = 0;
        int level = 0;

        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();

            builder.append(currentNode.getValue());

            if (level == 0) {
                level++;
                builder.append('\n');
            } else if ((numAdded + numSkipped) == (int) (Math.pow(2, level) + 1)) {
                builder.append('\n');
                level++;
            } else {
                builder.append(' ');
            }
            numAdded++;

            if (currentNode.getLeft() != null) {
                nodeQueue.add(currentNode.getLeft());
            } else {
                numSkipped++;
            }

            if (currentNode.getRight() != null) {
                nodeQueue.add(currentNode.getRight());
            } else {
                numSkipped++;
            }

        }
        return builder.toString();
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
            if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null && currentNode.getLeft() != null) {
                return currentNode.getLeft();
            } else if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                return null;
            } else {
                currentNode.setValue(getMinPredecessor(currentNode.getRight()));
                currentNode.setRight(removeHelper(currentNode.getRight(), currentNode.getValue()));
            }
        }
        return currentNode;
    }

    private int getMinPredecessor(Node currentNode) {
        int minVal = currentNode.getValue();
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
            minVal = currentNode.getValue();
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
