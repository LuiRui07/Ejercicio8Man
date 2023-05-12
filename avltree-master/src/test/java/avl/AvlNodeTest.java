package avl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: Antonio J. Nebro Date: 09/07/13 Time: 15:29
 */
public class AvlNodeTest {

    private AvlNode<Integer> node;

    @Before
    public void setUp() throws Exception {
        node = new AvlNode<Integer>(5);
    }

    @After
    public void tearDown() throws Exception {
        node = null;
    }

    /*@Test
    public void testHasLeft() {
        assertFalse("testHasLeft", node.hasLeft());
        AvlNode<Integer> node2 = new AvlNode<Integer>(6);
        node.setLeft(node2);
        assertTrue("testHasLeft", node.hasLeft());
    }*/

    @Test
    public void testGetSetLeft() {
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> left = new AvlNode<String>("B");
        node.setLeft(left);
        assertEquals(left, node.getLeft());
    }

    /*@Test
    public void testHasRight() {
        assertFalse("testHasRight", node.hasRight());
        AvlNode<Integer> node2 = new AvlNode<Integer>(6);
        node.setRight(node2);
        assertTrue("testHasRight", node.hasRight());
    }*/

    @Test
    public void testGetSetRight() {
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> right = new AvlNode<String>("B");
        node.setRight(right);
        assertEquals(right, node.getRight());
    }

    @Test
    public void testGetSetParent() {
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> parent = new AvlNode<String>("B");
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }

    @Test
    public void testGetSetItem() {
        AvlNode<String> node = new AvlNode<String>("A");
        String item = "B";
        node.setItem(item);
        assertEquals(item, node.getItem());
    }

    @Test
    public void testUpdateHeightWithNoChildren() {
        AvlNode<String> node = new AvlNode<>("test");
        node.updateHeight();
        assertEquals(0, node.getHeight());
    }

    @Test
    public void testUpdateHeightWithLeftChild() {
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> leftChild = new AvlNode<>("left");
        node.setLeft(leftChild);
        node.updateHeight();
        assertEquals(1, node.getHeight());
    }

    @Test
    public void testUpdateHeightWithRightChild() {
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> rightChild = new AvlNode<>("right");
        node.setRight(rightChild);
        node.updateHeight();
        assertEquals(1, node.getHeight());
    }

    @Test
    public void testUpdateHeightWithBothChildren() {
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> leftChild = new AvlNode<>("left");
        AvlNode<String> rightChild = new AvlNode<>("right");
        node.setLeft(leftChild);
        node.setRight(rightChild);
        node.updateHeight();
        assertEquals(1, node.getHeight());
    }

    @Test
    public void shouldSetHeight() {
        int expectedHeight = 1000213;
        node.setHeight(expectedHeight);
        assertEquals("Height is different from expected.", expectedHeight, node.getHeight());
    }

    @Test
    public void testHasParent() {
        AvlNode<String> node = new AvlNode<String>("A");
        assertFalse(node.hasParent());
        AvlNode<String> parent = new AvlNode<String>("B");
        node.setParent(parent);
        assertTrue(node.hasParent());
    }

    @Test
    public void testIsLeaf() {
        AvlNode<String> node = new AvlNode<String>("A");
        assertTrue(node.isLeaf());
        node.setLeft(new AvlNode<String>("B"));
        assertFalse(node.isLeaf());
    }

    @Test
    public void testHasOnlyALeftChild() {
        AvlNode<String> node = new AvlNode<String>("A");
        node.setLeft(new AvlNode<String>("B"));
        assertTrue(node.hasOnlyALeftChild());

        node.setRight(new AvlNode<String>("C"));
        assertFalse(node.hasOnlyALeftChild());
    }

    @Test
    public void testHasOnlyARightChild() {
        AvlNode<String> node = new AvlNode<String>("A");
        node.setRight(new AvlNode<String>("B"));
        assertTrue(node.hasOnlyARightChild());

        node.setLeft(new AvlNode<String>("C"));
        assertFalse(node.hasOnlyARightChild());
    }

    @Test
    public void testGetClosestNode() {
        AvlNode<String> node1 = new AvlNode<String>("A");
        AvlNode<String> node2 = new AvlNode<String>("B");
        AvlNode<String> node3 = new AvlNode<String>("C");

        // Prueba cuando el nodo más cercano es null
        assertNull(node1.getClosestNode());

        // Prueba después de establecer el nodo más cercano
        node1.setClosestNode(node2);
        assertEquals(node2, node1.getClosestNode());

        // Prueba después de actualizar el nodo más cercano
        node1.setClosestNode(node3);
        assertEquals(node3, node1.getClosestNode());
    }

    @Test
    public void testSetClosestNode() {
        AvlNode<String> node1 = new AvlNode<String>("A");
        AvlNode<String> node2 = new AvlNode<String>("B");
        AvlNode<String> node3 = new AvlNode<String>("C");

        // Prueba estableciendo el nodo más cercano a null
        node1.setClosestNode(null);
        assertNull(node1.getClosestNode());

        // Prueba estableciendo el nodo más cercano a otro nodo
        node1.setClosestNode(node2);
        assertEquals(node2, node1.getClosestNode());

        // Prueba actualizando el nodo más cercano
        node1.setClosestNode(node3);
        assertEquals(node3, node1.getClosestNode());
    }
}
