package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import tree._116_PopulatingNextRightPointersInEachNode.Node;

import static org.junit.Assert.*;

public class _116_PopulatingNextRightPointersInEachNodeTest {

    _116_PopulatingNextRightPointersInEachNode target = null;

    @Before
    public void before() throws Exception {
        target = new _116_PopulatingNextRightPointersInEachNode();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testConnect1() throws Exception {
        Node root = target.connect(null);
        assertNull(root);
    }

    @Test
    public void testConnect2() throws Exception {
        Node root = new Node(1, null, null, null);
        Node node = target.connect(root);
        assertEquals(node, root);
    }

    @Test
    public void testConnect3() throws Exception {
        Node root = new Node(1,
                new Node(2, null, null, null),
                new Node(3, null, null, null), null);
        Node node = target.connect(root);
        assertEquals(2, node.left.val);
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
        assertEquals(3, node.left.next.val);
    }
}
