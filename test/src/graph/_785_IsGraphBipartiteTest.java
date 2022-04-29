package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _785_IsGraphBipartiteTest {

    _785_IsGraphBipartite target = null;

    @Before
    public void before() throws Exception {
        target = new _785_IsGraphBipartite();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsBipartite1() throws Exception {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        boolean isBipartite = target.isBipartite(graph);
        assertFalse(isBipartite);
    }

    @Test
    public void testIsBipartite2() throws Exception {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean isBipartite = target.isBipartite(graph);
        assertTrue(isBipartite);
    }

    @Test
    public void testIsBipartite3() throws Exception {
        int[][] graph = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
        boolean isBipartite = target.isBipartite(graph);
        assertFalse(isBipartite);
    }
}
