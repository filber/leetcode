package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1695_MaximumErasureValueTest {

    _1695_MaximumErasureValue target = null;

    @Before
    public void before() throws Exception {
        target = new _1695_MaximumErasureValue();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaximumUniqueSubarray1() throws Exception {
        int[] nums = {4, 2, 4, 5, 6};
        int sum = target.maximumUniqueSubarray(nums);
        assertEquals(17, sum);
    }

    @Test
    public void testMaximumUniqueSubarray2() throws Exception {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int sum = target.maximumUniqueSubarray(nums);
        assertEquals(8, sum);
    }

    @Test
    public void testMaximumUniqueSubarray3() throws Exception {
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2};
        int sum = target.maximumUniqueSubarray(nums);
        assertEquals(2, sum);
    }

    @Test
    public void testMaximumUniqueSubarray4() throws Exception {
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 3};
        int sum = target.maximumUniqueSubarray(nums);
        assertEquals(5, sum);
    }
}
