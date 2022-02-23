package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _152_MaximumProductSubarrayTest {

    _152_MaximumProductSubarray target = null;

    @Before
    public void before() throws Exception {
        target = new _152_MaximumProductSubarray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxProduct1() throws Exception {
        int product = target.maxProduct(new int[]{2, 3, -2, 4});
        assertEquals(6, product);
    }

    @Test
    public void testMaxProduct2() throws Exception {
        int product = target.maxProduct(new int[]{-2, 0, -1});
        assertEquals(0, product);
    }

    @Test
    public void testMaxProduct3() throws Exception {
        int product = target.maxProduct(new int[]{0, 2});
        assertEquals(2, product);
    }

    @Test
    public void testMaxProduct4() throws Exception {
        int product = target.maxProduct(new int[]{-2, 3, -4});
        assertEquals(24, product);
    }
}
