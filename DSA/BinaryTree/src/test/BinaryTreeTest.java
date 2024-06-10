import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(9);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(2);
        binaryTree.add(4);
    }

    @Test
    void addSuccess() {
        ArrayList<Integer> testAgainst =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(testAgainst, binaryTree.getNodesInList());
    }

    @Test
    void addFailure() {
        // Adding a node already in the tree should result in no new nodes being added
//        Assertions.assertFalse(binaryTree.add(3));
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(9);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(2);
        binaryTree.add(4);
        ArrayList<Integer> testAgainst =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(testAgainst, binaryTree.getNodesInList());
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