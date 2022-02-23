package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import graph._133_CloneGraph.Node;

import static org.junit.Assert.*;

public class _133_CloneGraphTest {

    _133_CloneGraph target = null;

    @Before
    public void before() throws Exception {
        target = new _133_CloneGraph();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCloneGraph1() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(one);
        four.neighbors.add(three);

        Node cNode = target.cloneGraph(one);
        assertEquals(1, cNode.val);
        assertEquals(2, cNode.neighbors.size());
        assertEquals(2, cNode.neighbors.get(0).val);
        assertEquals(4, cNode.neighbors.get(1).val);
    }

    @Test
    public void testCloneGraph2() throws Exception {
        Node one = new Node(1);
        Node cNode = target.cloneGraph(one);
        assertEquals(1, cNode.val);
        assertTrue(cNode.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraph3() throws Exception {
        Node cNode = target.cloneGraph(null);
        assertNull(cNode);
    }
}
