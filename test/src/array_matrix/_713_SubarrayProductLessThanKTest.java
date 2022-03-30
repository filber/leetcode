package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _713_SubarrayProductLessThanKTest {

    _713_SubarrayProductLessThanK target = null;

    @Before
    public void before() throws Exception {
        target = new _713_SubarrayProductLessThanK();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumSubarrayProductLessThanK1() throws Exception {
        int num = target.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        assertEquals(8, num);
    }

    @Test
    public void testNumSubarrayProductLessThanK2() throws Exception {
        int num = target.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 60);
        assertEquals(7, num);
    }

    @Test
    public void testNumSubarrayProductLessThanK3() throws Exception {
        int num = target.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 50);
        assertEquals(6, num);
    }
}
