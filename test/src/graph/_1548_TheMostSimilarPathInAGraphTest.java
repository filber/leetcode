package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1548_TheMostSimilarPathInAGraphTest {

    _1548_TheMostSimilarPathInAGraph target = null;

    @Before
    public void before() throws Exception {
        target = new _1548_TheMostSimilarPathInAGraph();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMostSimilar1() {
        String[] names = {"ATL", "PEK", "LAX", "DXB", "HND"};
        int[][] roads = new int[][]{{0, 2}, {0, 3}, {1, 2}, {1, 3}, {1, 4}, {2, 4}};
        String[] targetPath = {"ATL", "DXB", "HND", "LAX"};

        int[] path = target.mostSimilar(names, roads, targetPath);

        assertArrayEquals(new int[]{0, 2, 4, 2}, path);
        assertEquals(1, target.editDistance(targetPath, names, path));
    }

    @Test
    public void testMostSimilar2() {
        String[] names = {"ATL", "PEK", "LAX", "DXB"};
        int[][] roads = new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 1}, {3, 1}, {3, 2}};
        String[] targetPath = {"ABC", "DEF", "GHI", "JKL"};

        int[] path = target.mostSimilar(names, roads, targetPath);

        assertArrayEquals(new int[]{0, 1, 0, 1}, path);
        assertEquals(4, target.editDistance(targetPath, names, path));
    }

    @Test
    public void testMostSimilar3() {
        String[] names = {"ATL", "PEK", "LAX", "ATL", "DXB", "HND"};
        int[][] roads = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        String[] targetPath = {"ATL", "DXB", "HND", "DXB", "ATL", "LAX", "PEK"};

        int[] path = target.mostSimilar(names, roads, targetPath);

        assertArrayEquals(new int[]{3, 4, 5, 4, 3, 2, 1}, path);
        assertEquals(0, target.editDistance(targetPath, names, path));
    }
}
