package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _576_OutOfBoundaryPathsTest {

    _576_OutOfBoundaryPaths target;

    @Before
    public void before() throws Exception {
        target = new _576_OutOfBoundaryPaths();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindPaths1() throws Exception {
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRow = 0;
        int startColumn = 0;
        int paths = target.findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(6, paths);
    }

    @Test
    public void testFindPaths2() throws Exception {
        int m = 1;
        int n = 3;
        int maxMove = 3;
        int startRow = 0;
        int startColumn = 1;
        int paths = target.findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(12, paths);
    }

    @Test
    public void testFindPaths3() throws Exception {
        int m = 1;
        int n = 3;
        int maxMove = 0;
        int startRow = 0;
        int startColumn = 1;
        int paths = target.findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(0, paths);
    }
} 
