package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _310_MinimumHeightTreesTest {

    _310_MinimumHeightTrees target = null;

    @Before
    public void before() throws Exception {
        target = new _310_MinimumHeightTrees();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMinHeightTrees1() throws Exception {
        int[][] edges = {
                {1, 0}, {1, 2}, {1, 3}
        };
        int n = 4;
        List<Integer> roots = target.findMinHeightTrees(n, edges);
        assertEquals(1, roots.size());
        assertEquals(1, roots.get(0).intValue());
    }

    @Test
    public void testFindMinHeightTrees2() throws Exception {
        int[][] edges = {
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}
        };
        int n = 6;
        List<Integer> roots = target.findMinHeightTrees(n, edges);
        assertEquals(2, roots.size());
        Set<Integer> set = new HashSet<>(roots);
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
    }

    @Test
    public void testFindMinHeightTrees3() throws Exception {
        int[][] edges = {};
        int n = 1;
        List<Integer> roots = target.findMinHeightTrees(n, edges);
        assertEquals(1, roots.size());
        Set<Integer> set = new HashSet<>(roots);
        assertTrue(set.contains(0));
    }
}