package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _15_3SumTest {

    _15_3Sum target = null;

    @Before
    public void before() throws Exception {
        target = new _15_3Sum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testThreeSum1() throws Exception {
        List<List<Integer>> list = target.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, list.size());
        assertArrayEquals(new Integer[]{-1, -1, 2}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{-1, 0, 1}, list.get(1).toArray(new Integer[0]));
    }

    @Test
    public void testThreeSum2() throws Exception {
        List<List<Integer>> list = target.threeSum(new int[]{});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThreeSum3() throws Exception {
        List<List<Integer>> list = target.threeSum(new int[]{0});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThreeSum4() throws Exception {
        List<List<Integer>> list = target.threeSum(new int[]{1, -1, -1, 0});
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{-1, 0, 1}, list.get(0).toArray(new Integer[0]));
    }
}
