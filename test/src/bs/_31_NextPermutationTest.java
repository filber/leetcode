package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _31_NextPermutationTest {

    _31_NextPermutation target = null;

    @Before
    public void before() throws Exception {
        target = new _31_NextPermutation();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNextPermutation1() throws Exception {
        int[] nums = {1, 2, 3};
        target.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 3, 2}, nums);
    }

    @Test
    public void testNextPermutation2() throws Exception {
        int[] nums = {3, 2, 1};
        target.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    public void testNextPermutation3() throws Exception {
        int[] nums = {1, 1, 5};
        target.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 5, 1}, nums);
    }

    @Test
    public void testNextPermutation4() throws Exception {
        int[] nums = {2, 5, 3, 2, 1};
        target.nextPermutation(nums);
        assertArrayEquals(new int[]{3, 1, 2, 2, 5}, nums);
    }
}
