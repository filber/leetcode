package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1001_GridIlluminationTest {

    _1001_GridIllumination target = null;

    @Before
    public void before() throws Exception {
        target = new _1001_GridIllumination();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGridIllumination1() throws Exception {
        int[] ans = target.gridIllumination(5,
                new int[][]{{0, 0}, {4, 4}},
                new int[][]{{1, 1}, {1, 0}});
        assertArrayEquals(new int[]{1, 0}, ans);
    }

    @Test
    public void testGridIllumination2() throws Exception {
        int[] ans = target.gridIllumination(5,
                new int[][]{{0, 0}, {4, 4}},
                new int[][]{{1, 1}, {1, 1}});
        assertArrayEquals(new int[]{1, 1}, ans);
    }

    @Test
    public void testGridIllumination3() throws Exception {
        int[] ans = target.gridIllumination(5,
                new int[][]{{0, 0}, {0, 4}},
                new int[][]{{0, 4}, {0, 1}, {1, 4}});
        assertArrayEquals(new int[]{1, 1, 0}, ans);
    }

    @Test
    public void testGridIllumination4() throws Exception {
        int[] ans = target.gridIllumination(5,
                new int[][]{{0, 0}, {0, 4}},
                new int[][]{{3, 1}, {0, 4}, {0, 1}, {1, 3}, {3, 1}});
        assertArrayEquals(new int[]{1, 1, 1, 0, 0}, ans);
    }

    @Test
    public void testGridIllumination5() throws Exception {
        int[] ans = target.gridIllumination(6,
                new int[][]{{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}},
                new int[][]{{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}});
        assertArrayEquals(new int[]{1, 0, 1, 1, 0, 1}, ans);
    }

    @Test
    public void testGridIllumination6() throws Exception {
        int[] ans = target.gridIllumination(1,
                new int[][]{{0, 0}, {0, 0}},
                new int[][]{{0, 0}, {0, 0}});
        assertArrayEquals(new int[]{1, 0}, ans);
    }
}
