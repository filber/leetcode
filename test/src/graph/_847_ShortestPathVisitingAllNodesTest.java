package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _847_ShortestPathVisitingAllNodesTest {

    _847_ShortestPathVisitingAllNodes target = null;

    @Before
    public void before() throws Exception {
        target = new _847_ShortestPathVisitingAllNodes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testShortestPathLength1() throws Exception {
        int len = target.shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}});
        assertEquals(4, len);
    }

    @Test
    public void testShortestPathLength2() throws Exception {
        int len = target.shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}});
        assertEquals(4, len);
    }

} 
