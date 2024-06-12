public class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;

    public int getValue() {
        return value;
    }

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void updateHeight() {
        if (right == null && left == null) {
            setHeight(0);
        } else if (right == null) {
            setHeight(left.height + 1);
        } else if (left == null) {
            setHeight(right.height + 1);
        } else {
            if (rightTallerThanLeftChild()) {
                setHeight(right.height + 1);
            } else {
                setHeight(left.height + 1);
            }
        }
    }

    private boolean rightTallerThanLeftChild() {
        return right.height >= left.height;
    }

    private void setHeight(int height) {
        this.height = height;
    }
}
