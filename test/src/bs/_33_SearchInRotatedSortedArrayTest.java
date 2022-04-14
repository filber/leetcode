package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _33_SearchInRotatedSortedArrayTest {

    _33_SearchInRotatedSortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _33_SearchInRotatedSortedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearch1() throws Exception {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int idx = target.search(nums, 0);
        assertEquals(4, idx);
    }

    @Test
    public void testSearch2() throws Exception {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int idx = target.search(nums, 3);
        assertEquals(-1, idx);
    }

    @Test
    public void testSearch3() throws Exception {
        int[] nums = {1};
        int idx = target.search(nums, 0);
        assertEquals(-1, idx);
    }

    @Test
    public void testSearch4() throws Exception {
        int[] nums = {3, 1};
        int idx = target.search(nums, 1);
        assertEquals(1, idx);
    }
}
