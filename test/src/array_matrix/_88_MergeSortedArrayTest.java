package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _88_MergeSortedArrayTest {

    _88_MergeSortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _88_MergeSortedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMerge1() throws Exception {
        int[] nums1 = new int[]{1};
        target.merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void testMerge2() throws Exception {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        target.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void testMerge3() throws Exception {
        int[] nums1 = new int[]{4, 0, 0, 0, 0, 0};
        target.merge(nums1, 1, new int[]{1, 2, 3, 5, 6}, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }
}
