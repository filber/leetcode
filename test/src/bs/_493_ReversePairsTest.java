package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _493_ReversePairsTest {

    _493_ReversePairs target = null;

    @Before
    public void before() throws Exception {
        target = new _493_ReversePairs();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testReversePairs1() throws Exception {
        int[] nums = {1, 3, 2, 3, 1};
        int pairs = target.reversePairs(nums);
        // [3,1],[3,1]
        assertEquals(2, pairs);
    }

    @Test
    public void testReversePairs2() throws Exception {
        int[] nums = {2, 4, 3, 5, 1};
        int pairs = target.reversePairs(nums);
        // [4,1],[3,1],[5,1]
        assertEquals(3, pairs);
    }

    @Test
    public void testReversePairs3() throws Exception {
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int pairs = target.reversePairs(nums);
        assertEquals(0, pairs);
    }
}
