package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _215_KthLargestElementInAnArrayTest {

    _215_KthLargestElementInAnArray target = null;

    @Before
    public void before() throws Exception {
        target = new _215_KthLargestElementInAnArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindKthLargest1() throws Exception {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kth = target.findKthLargest(nums, k);
        assertEquals(5, kth);
    }

    @Test
    public void testFindKthLargest2() throws Exception {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kth = target.findKthLargest(nums, k);
        assertEquals(4, kth);
    }
}