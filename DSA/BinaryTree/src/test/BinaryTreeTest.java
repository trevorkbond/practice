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
        binaryTree.remove(1);
        binaryTree.remove(3);
        binaryTree.remove(5);
        binaryTree.remove(7);
        binaryTree.remove(9);
        ArrayList<Integer> testAgainst =
                new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        assertEquals(testAgainst, binaryTree.getNodesInList());
    }

    @Test
    void containsSuccess() {
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(7));
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(10));
        assertTrue(binaryTree.contains(9));
        assertTrue(binaryTree.contains(8));
        assertTrue(binaryTree.contains(4));
        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(6));
    }

    @Test
    void containsFailure() {
        binaryTree.remove(7);
        assertFalse(binaryTree.contains(7));
        assertFalse(binaryTree.contains(11));
        assertFalse(binaryTree.contains(-1));
    }
}