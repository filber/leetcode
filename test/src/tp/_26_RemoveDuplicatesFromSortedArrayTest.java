package tp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

public class _26_RemoveDuplicatesFromSortedArrayTest {

    _26_RemoveDuplicatesFromSortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _26_RemoveDuplicatesFromSortedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveDuplicates1() throws Exception {
        int[] nums = {1, 1, 2};
        int len = target.removeDuplicates(nums);
        assertEquals(2, len);
        int[] newArr = Arrays.copyOf(nums, len);
        int[] expected = {1, 2};
        assertArrayEquals(expected, newArr);
    }

    @Test
    public void testRemoveDuplicates2() throws Exception {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = target.removeDuplicates(nums);
        assertEquals(5, len);
        int[] newArr = Arrays.copyOf(nums, len);
        int[] expected = {0, 1, 2, 3, 4};
        assertArrayEquals(expected, newArr);
    }

    @Test
    public void testRemoveDuplicates3() throws Exception {
        int[] nums = {1, 2, 3, 4};
        int len = target.removeDuplicates(nums);
        assertEquals(4, len);
        int[] newArr = Arrays.copyOf(nums, len);
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, newArr);
    }

    @Test
    public void testRemoveDuplicates4() throws Exception {
        int[] nums = {1, 1};
        int len = target.removeDuplicates(nums);
        assertEquals(1, len);
        int[] newArr = Arrays.copyOf(nums, len);
        int[] expected = {1};
        assertArrayEquals(expected, newArr);
    }

    @Test
    public void testRemoveDuplicates5() throws Exception {
        int[] nums = {1};
        int len = target.removeDuplicates(nums);
        assertEquals(1, len);
        int[] newArr = Arrays.copyOf(nums, len);
        int[] expected = {1};
        assertArrayEquals(expected, newArr);
    }
}
