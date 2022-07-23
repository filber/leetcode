package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _315_CountOfSmallerNumbersAfterSelfTest {

    _315_CountOfSmallerNumbersAfterSelf target;

    @Before
    public void before() throws Exception {
        target = new _315_CountOfSmallerNumbersAfterSelf();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCountSmaller1() throws Exception {
        int[] nums = {5, 2, 6, 1};
        List<Integer> list = target.countSmaller(nums);
        assertArrayEquals(new Integer[]{2, 1, 1, 0}, list.toArray(new Integer[0]));
    }

    @Test
    public void testCountSmaller2() throws Exception {
        int[] nums = {-1};
        List<Integer> list = target.countSmaller(nums);
        assertArrayEquals(new Integer[]{0}, list.toArray(new Integer[0]));
    }

    @Test
    public void testCountSmaller3() throws Exception {
        int[] nums = {-1, -1};
        List<Integer> list = target.countSmaller(nums);
        assertArrayEquals(new Integer[]{0, 0}, list.toArray(new Integer[0]));
    }
}
