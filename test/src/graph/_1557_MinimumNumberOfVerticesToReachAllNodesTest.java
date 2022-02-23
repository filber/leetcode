package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class _1557_MinimumNumberOfVerticesToReachAllNodesTest {

    _1557_MinimumNumberOfVerticesToReachAllNodes target = null;

    @Before
    public void before() throws Exception {
        target = new _1557_MinimumNumberOfVerticesToReachAllNodes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindSmallestSetOfVertices1() throws Exception {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> e_0_1 = new ArrayList<>();
        edges.add(e_0_1);
        e_0_1.add(0);
        e_0_1.add(1);
        List<Integer> e_0_2 = new ArrayList<>();
        edges.add(e_0_2);
        e_0_2.add(0);
        e_0_2.add(2);
        List<Integer> e_2_5 = new ArrayList<>();
        edges.add(e_2_5);
        e_2_5.add(2);
        e_2_5.add(5);
        List<Integer> e_3_4 = new ArrayList<>();
        edges.add(e_3_4);
        e_3_4.add(3);
        e_3_4.add(4);
        List<Integer> e_4_2 = new ArrayList<>();
        edges.add(e_4_2);
        e_4_2.add(4);
        e_4_2.add(2);

        List<Integer> vertices = target.findSmallestSetOfVertices(6, edges);
        assertArrayEquals(new Integer[]{0, 3}, vertices.toArray(new Integer[0]));
    }

} 
