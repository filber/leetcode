package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._117_PopulatingNextRightPointersInEachNodeII.Node;

import static org.junit.Assert.*;

public class _117_PopulatingNextRightPointersInEachNodeIITest {

    _117_PopulatingNextRightPointersInEachNodeII target = null;

    @Before
    public void before() throws Exception {
        target = new _117_PopulatingNextRightPointersInEachNodeII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testConnect1() throws Exception {
        Node node = target.connect(null);
        assertNull(node);
    }

    @Test
    public void testConnect2() throws Exception {
        Node root = new Node(1, null, null, null);
        Node node = target.connect(root);
        assertEquals(1, node.val);
    }

    @Test
    public void testConnect3() throws Exception {
        Node root = new Node(1,
                new Node(2, null, null, null),
                new Node(3, null, null, null),
                null);
        Node node = target.connect(root);
        assertEquals(3, node.left.next.val);
    }

    @Test
    public void testConnect4() throws Exception {
        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        new Node(6),
                        new Node(7), null),
                null);
        Node node = target.connect(root);
        Node four = node.left.left;
        assertEquals(4, four.val);
        assertEquals(5, four.next.val);
        assertEquals(6, four.next.next.val);
        assertEquals(7, four.next.next.next.val);
    }

    @Test
    public void testConnect5() throws Exception {
        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        null,
                        new Node(7), null),
                null);

        Node node = target.connect(root);
        Node four = node.left.left;
        assertEquals(4, four.val);
        assertEquals(5, four.next.val);
        assertEquals(7, four.next.next.val);
    }

    @Test
    public void testConnect6() throws Exception {
        Node root = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8), null, null),
                        new Node(5),
                        null),
                new Node(3,
                        new Node(6,
                                new Node(9), null, null),
                        new Node(7,
                                new Node(10), null, null),
                        null),
                null);

        Node node = target.connect(root);

        Node four = node.left.left;
        assertEquals(4, four.val);
        assertEquals(5, four.next.val);
        assertEquals(6, four.next.next.val);
        assertEquals(7, four.next.next.next.val);

        Node eight = node.left.left.left;
        assertEquals(8, eight.val);
        assertEquals(9, eight.next.val);
        assertEquals(10, eight.next.next.val);
    }
} 
