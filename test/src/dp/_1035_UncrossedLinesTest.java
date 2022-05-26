package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1035_UncrossedLinesTest {

    _1035_UncrossedLines target = null;

    @Before
    public void before() throws Exception {
        target = new _1035_UncrossedLines();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxUncrossedLines1() throws Exception {
        int[] A = {1, 4, 2};
        int[] B = {1, 2, 4};
        int len = target.maxUncrossedLines(A, B);
        assertEquals(2, len);
    }

    @Test
    public void testMaxUncrossedLines2() throws Exception {
        int[] A = {2, 5, 1, 2, 5};
        int[] B = {10, 5, 2, 1, 5, 2};
        int len = target.maxUncrossedLines(A, B);
        assertEquals(3, len);
    }

    @Test
    public void testMaxUncrossedLines3() throws Exception {
        int[] A = {1, 3, 7, 1, 7, 5};
        int[] B = {1, 9, 2, 5, 1};
        int len = target.maxUncrossedLines(A, B);
        assertEquals(2, len);
    }
}
