package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1091_ShortestPathInBinaryMatrixTest {

    _1091_ShortestPathInBinaryMatrix target = null;

    @Before
    public void before() throws Exception {
        target = new _1091_ShortestPathInBinaryMatrix();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testShortestPathBinaryMatrix1() throws Exception {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        int path = target.shortestPathBinaryMatrix(grid);
        assertEquals(4, path);
    }

    @Test
    public void testShortestPathBinaryMatrix2() throws Exception {
        int[][] grid = {
                {0, 1},
                {1, 0}};
        int path = target.shortestPathBinaryMatrix(grid);
        assertEquals(2, path);
    }

    @Test
    public void testShortestPathBinaryMatrix3() throws Exception {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        int path = target.shortestPathBinaryMatrix(grid);
        assertEquals(-1, path);
    }
}
