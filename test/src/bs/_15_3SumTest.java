package bs;

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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = target.threeSum(nums);
        assertEquals(2, list.size());
    }

    @Test
    public void testThreeSum2() throws Exception {
        int[] nums = {0, 1, 1};
        List<List<Integer>> list = target.threeSum(nums);
        assertEquals(0, list.size());
    }

    @Test
    public void testThreeSum3() throws Exception {
        int[] nums = {0, 0, 0};
        List<List<Integer>> list = target.threeSum(nums);
        assertEquals(1, list.size());
    }

    @Test
    public void testThreeSum4() throws Exception {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> list = target.threeSum(nums);
        assertEquals(1, list.size());
    }
}
