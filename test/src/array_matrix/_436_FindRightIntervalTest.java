package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _436_FindRightIntervalTest {

    _436_FindRightInterval target = null;

    @Before
    public void before() throws Exception {
        target = new _436_FindRightInterval();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindRightInterval1() throws Exception {
        int[] right = target.findRightInterval(new int[][]{{1, 2}});
        assertArrayEquals(new int[]{-1}, right);
    }

    @Test
    public void testFindRightInterval2() throws Exception {
        int[] right = target.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        assertArrayEquals(new int[]{-1, 0, 1}, right);
    }

    @Test
    public void testFindRightInterval3() throws Exception {
        int[] right = target.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
        assertArrayEquals(new int[]{-1, 2, -1}, right);
    }
}
