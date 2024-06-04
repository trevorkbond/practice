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
    void addSuccess() {
        assertTrue(binaryTree.add(3));
        assertEquals(binaryTree.getSize(), 1);
        assertTrue(binaryTree.add(2));
        assertEquals(binaryTree.getSize(), 2);
        assertTrue(binaryTree.add(1));
        assertEquals(binaryTree.getSize(), 3);
        assertTrue(binaryTree.add(0));
        assertEquals(binaryTree.getSize(), 4);
    }

    @Test
    void addFailure() {
        binaryTree.add(3);
        Assertions.assertFalse(binaryTree.add(3));
        assertEquals(binaryTree.getSize(), 1);
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}