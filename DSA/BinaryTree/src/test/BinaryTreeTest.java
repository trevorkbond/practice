import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
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
    void removeSuccess() {
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.remove(2);
//        assertEquals(binaryTree.getSize(), 1);
        assertFalse(binaryTree.contains(2));
    }

    @Test
    void containsSuccess() {
        binaryTree.add(3);
        assertTrue(binaryTree.contains(3));
        binaryTree.add(5);
        assertTrue(binaryTree.contains(5));
    }

    @Test
    void containsFailure() {
        assertFalse(binaryTree.contains(7));
        binaryTree.add(7);
        assertFalse(binaryTree.contains(6));
    }
}