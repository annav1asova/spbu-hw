package spbu.sem3.hw2.task2;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* test class for bst with iterator. */
public class TreeTest {
    @Test
    public void emptinessTest() {
        Tree<Integer> tree = new Tree<>();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void additionTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(9);
        tree.add(4);
        tree.add(10);
        assertEquals(tree.printTree(), " (5 (4) (9 (10)))");
    }
    
    @Test
    public void removeNodeWothoutChildrenTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(9);
        tree.add(4);
        tree.add(10);
        tree.add(7);
        tree.add(3);
        tree.add(1);
        tree.remove(1);
        assertEquals(tree.printTree(), " (5 (4 (3)) (9 (7) (10)))");
    }

    @Test
    public void removeNodeWithTwoChildrenTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(9);
        tree.add(4);
        tree.add(10);
        tree.add(7);
        tree.add(3);
        tree.add(1);
        tree.remove(5);
        assertEquals(tree.printTree(), " (7 (4 (3 (1))) (9 (10)))");
    }

    @Test
    public void iteratorTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(15);
        tree.add(12);
        tree.add(18);
        tree.add(8);
        tree.add(9);
        tree.add(28);
        Iterator<Integer> it = tree.iterator();
        ArrayList<Integer> actual = new ArrayList<>();
        while (it.hasNext()) {
            actual.add(it.next());
        }
        ArrayList<Integer> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        Assert.assertEquals(actual, expected);
    }
}