package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _329_LongestIncreasingPathInAMatrixTest {

    _329_LongestIncreasingPathInAMatrix target = null;

    @Before
    public void before() throws Exception {
        target = new _329_LongestIncreasingPathInAMatrix();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestIncreasingPath1() throws Exception {
        // 4 - [1, 2, 6, 9]
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        int len = target.longestIncreasingPath(matrix);
        assertEquals(4, len);
    }

    @Test
    public void testLongestIncreasingPath2() throws Exception {
        // 4 - [3, 4, 5, 6]
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}};
        int len = target.longestIncreasingPath(matrix);
        assertEquals(4, len);
    }

    @Test
    public void testLongestIncreasingPath3() throws Exception {
        int[][] matrix = {
                {1}};
        int len = target.longestIncreasingPath(matrix);
        assertEquals(1, len);
    }

    @Test
    public void testLongestIncreasingPath4() throws Exception {
        // 4 - [1, 2, 3, 4]
        int[][] matrix = {
                {1, 2},
                {4, 3}};
        int len = target.longestIncreasingPath(matrix);
        assertEquals(4, len);
    }
}
