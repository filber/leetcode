package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import tree._EX_ConnectAllSiblings.Node;

public class _EX_ConnectAllSiblingsTest {

    _EX_ConnectAllSiblings target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_ConnectAllSiblings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPopulateSiblingPointers1() throws Exception {
        Node root = new Node(100
                , new Node(50,
                new Node(25), new Node(75)),
                new Node(200, null, new Node(300, null, new Node(350))));

        target.populateSiblingPointers(root);
        assertArrayEquals(new Integer[]{100, 50, 200, 25, 75, 300, 350}, root.toArray());
    }
}
