import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private static BinaryTree binaryTree;

    @BeforeAll
    static void setUp() {
        binaryTree = new BinaryTree();

    }

    @Test
    void add() {
        Assertions.assertTrue(binaryTree.add(3));
        Assertions.assertEquals(binaryTree.getSize(), 1);
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}