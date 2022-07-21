package ps;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _238_ProductOfArrayExceptSelfTest {

    _238_ProductOfArrayExceptSelf target = null;

    @Before
    public void before() throws Exception {
        target = new _238_ProductOfArrayExceptSelf();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testProductExceptSelf1() throws Exception {
        int[] nums = {1, 2, 3, 4};
        int[] output = target.productExceptSelf(nums);
        assertArrayEquals(new int[]{24, 12, 8, 6}, output);
    }

    @Test
    public void testProductExceptSelf2() throws Exception {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] output = target.productExceptSelf(nums);
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, output);
    }
}
