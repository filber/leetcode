package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

public class _27_RemoveElementTest {

    _27_RemoveElement target = null;

    @Before
    public void before() throws Exception {
        target = new _27_RemoveElement();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveElement1() throws Exception {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = target.removeElement(nums, val);
        assertEquals(2, k);
        assertArrayEquals(new int[]{2, 2}, Arrays.copyOf(nums, k));
    }

    @Test
    public void testRemoveElement2() throws Exception {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = target.removeElement(nums, val);
        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 3, 0, 4}, Arrays.copyOf(nums, k));
    }

    @Test
    public void testRemoveElement3() throws Exception {
        int[] nums = {};
        int val = 2;
        int k = target.removeElement(nums, val);
        assertEquals(0, k);
    }
}
