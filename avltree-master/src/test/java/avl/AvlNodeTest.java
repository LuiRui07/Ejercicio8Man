package avl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

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

    @Test
    public void testHasLeft() {
        assertFalse("testHasLeft", node.hasLeft());
        AvlNode<Integer> node2 = new AvlNode<Integer>(6);
        node.setLeft(node2);
        assertTrue("testHasLeft", node.hasLeft());
    }

    @Test
    public void testHasRight() {
        assertFalse("testHasRight", node.hasRight());
        AvlNode<Integer> node2 = new AvlNode<Integer>(6);
        node.setRight(node2);
        assertTrue("testHasRight", node.hasRight());
    }

    @Test
    public void shouldSetHeight() {
        int expectedHeight = 1000213;
        node.setHeight(expectedHeight);
        assertEquals( expectedHeight, node.getHeight());
    }

    /**
     * @author Guillermo Pichaco Panal
     * Pablo Alarcon Carrión
     * Pablo Garcia Platero
     * Luis Ruiz Nuñez
     * Angela Roza Moreno
     **/


    @Test
    @DisplayName("Test que comprueba el metodo getLeft() y setLeft()")
    public void testGetSetLeft() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> left = new AvlNode<String>("B");

        //When
        node.setLeft(left);

        //Then
        assertEquals(left, node.getLeft());
    }

    @Test
    @DisplayName("Test que comprueba el metodo getRight() y setRight()")
    public void testGetSetRight() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> right = new AvlNode<String>("B");

        //When
        node.setRight(right);

        //Then
        assertEquals(right, node.getRight());
    }

    @Test
    @DisplayName("Test que comprueba el metodo getParent() y setParent()")
    public void testGetSetParent() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");
        AvlNode<String> parent = new AvlNode<String>("B");

        //When
        node.setParent(parent);

        //Then
        assertEquals(parent, node.getParent());
    }

    @Test
    @DisplayName("Test que comprueba el metodo getItem() y setItem()")
    public void testGetSetItem() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");
        String item = "B";

        //When
        node.setItem(item);

        //Then
        assertEquals(item, node.getItem());
    }

    @Test
    @DisplayName("Test que comprueba el metodo UpdateHeight() con hijos nulos")
    public void testUpdateHeightWithNoChildren() {
        //Given
        AvlNode<String> node = new AvlNode<>("test");

        //When
        node.updateHeight();

        //Then
        assertEquals(0, node.getHeight());
    }

    @Test
    @DisplayName("Test que comprueba el metodo UpdateHeight() con solo un hijo izquierdo")
    public void testUpdateHeightWithLeftChild() {
        //Given
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> leftChild = new AvlNode<>("left");

        //When
        node.setLeft(leftChild);
        node.updateHeight();

        //Then
        assertEquals(1, node.getHeight());
    }

    @Test
    @DisplayName("Test que comprueba el metodo UpdateHeight() con solo un hijo derecho")
    public void testUpdateHeightWithRightChild() {
        //Given
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> rightChild = new AvlNode<>("right");

        //When
        node.setRight(rightChild);
        node.updateHeight();

        //Then
        assertEquals(1, node.getHeight());
    }

    @Test
    @DisplayName("Test que comprueba el metodo UpdateHeight() con ambos hijos")
    public void testUpdateHeightWithBothChildren() {
        //Given
        AvlNode<String> node = new AvlNode<>("test");
        AvlNode<String> leftChild = new AvlNode<>("left");
        AvlNode<String> rightChild = new AvlNode<>("right");

        //When
        node.setLeft(leftChild);
        node.setRight(rightChild);
        node.updateHeight();

        //Then
        assertEquals(1, node.getHeight());
    }


    @Test
    @DisplayName("Test que comprueba el metodo HasParent()")
    public void testHasParent() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");
        //Then
        assertFalse(node.hasParent());

        //Given
        AvlNode<String> parent = new AvlNode<String>("B");

        //When
        node.setParent(parent);

        //Then
        assertTrue(node.hasParent());
    }

    @Test
    @DisplayName("Test que comprueba el metodo GetClosestNode() en los 3 posibles casos planteados")
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
    @DisplayName("Test que comprueba el metodo SetClosestNode() en los 3 posibles casos planteados")
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

    @Test
    @DisplayName("Test que comprueba el metodo IsLeaf()")
    public void testIsLeaf() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");

        //Then
        assertTrue(node.isLeaf());

        //When
        node.setLeft(new AvlNode<String>("B"));

        //Then
        assertFalse(node.isLeaf());
    }

    @Test
    @DisplayName("Test que comprueba el metodo HasOnlyALeftChild()")
    public void testHasOnlyALeftChild() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");

        //When
        node.setLeft(new AvlNode<String>("B"));

        //Then
        assertTrue(node.hasOnlyALeftChild());

        //When
        node.setRight(new AvlNode<String>("C"));

        //Then
        assertFalse(node.hasOnlyALeftChild());
    }

    @Test
    @DisplayName("Test que comprueba el metodo HasOnlyARightChild()")
    public void testHasOnlyARightChild() {
        //Given
        AvlNode<String> node = new AvlNode<String>("A");

        //When
        node.setRight(new AvlNode<String>("B"));

        //Then
        assertTrue(node.hasOnlyARightChild());

        //When
        node.setLeft(new AvlNode<String>("C"));

        //Then
        assertFalse(node.hasOnlyARightChild());
    }


}
