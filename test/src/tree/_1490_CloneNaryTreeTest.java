package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import tree._1490_CloneNaryTree.Node;

public class _1490_CloneNaryTreeTest {

    _1490_CloneNaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _1490_CloneNaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCloneTree1() throws Exception {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));

        Node cNode = target.cloneTree(root);
        assertEquals(1, cNode.val);
        assertEquals(3, cNode.children.size());
    }

} 
