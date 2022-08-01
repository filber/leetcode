package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _62_UniquePathsTest {

    _62_UniquePaths target = null;

    @Before
    public void before() throws Exception {
        target = new _62_UniquePaths();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testUniquePaths1() throws Exception {
        int m = 3;
        int n = 7;
        int paths = target.uniquePaths(m, n);
        assertEquals(28, paths);
    }

    @Test
    public void testUniquePaths2() throws Exception {
        int m = 3;
        int n = 2;
        int paths = target.uniquePaths(m, n);
        assertEquals(3, paths);
    }
}
