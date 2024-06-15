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

    public ImbalanceType getImbalanceType() {
        boolean leftNull = left == null;
        boolean rightNull = right == null;
        if (!leftNull && !rightNull) {
            if (left.height - right.height > 1) {
                // there is some sort of left imbalance
                return getTypeLeftImbalance();
            } else if (right.height - left.height > 1) {
                // there is some sort of right imbalance
                return getTypeRightImbalance();
            } else {
                return ImbalanceType.NONE;
            }
        } else if (!leftNull) {
            if (left.height > 0) {
                // there is some sort of left imbalance
                return getTypeLeftImbalance();
            } else {
                return ImbalanceType.NONE;
            }
        } else if (!rightNull) {
            if (right.height > 0) {
                // there is some sort of right imbalance
                return getTypeRightImbalance();
            } else {
                return ImbalanceType.NONE;
            }
        }
        return ImbalanceType.NONE;
    }

    private ImbalanceType getTypeLeftImbalance() {
        if (left.rightTallerThanLeftChild()) {
            return ImbalanceType.LEFT_RIGHT;
        } else {
            return ImbalanceType.LEFT_LEFT;
        }
    }

    private ImbalanceType getTypeRightImbalance() {
        if (right.rightTallerThanLeftChild()) {
            return ImbalanceType.RIGHT_RIGHT;
        } else {
            return ImbalanceType.RIGHT_LEFT;
        }
    }

    private boolean rightTallerThanLeftChild() {
        if (right != null && left == null) {
            return true;
        } else if (right == null && left != null) {
            return false;
        } else if (right == null) {
            //FIXME: Should I really just return true if both are null?
            return true;
        }
        return right.height >= left.height;
    }

    private void setHeight(int height) {
        this.height = height;
    }
}
