package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2009_MinimumNumberOfOperationsToMakeArrayContinuousTest {
    _2009_MinimumNumberOfOperationsToMakeArrayContinuous target = null;

    @Before
    public void before() throws Exception {
        target = new _2009_MinimumNumberOfOperationsToMakeArrayContinuous();
    }

    @Test
    public void test1() throws Exception {
        int[] nums = new int[]{4, 2, 5, 3};
        int operations = target.minOperations(nums);
        assertEquals(0, operations);
    }

    @Test
    public void test2() throws Exception {
        int[] nums = new int[]{1, 2, 3, 5, 6};
        int operations = target.minOperations(nums);
        assertEquals(1, operations);
    }

    @Test
    public void test3() throws Exception {
        int[] nums = new int[]{1, 10, 100, 1000};
        int operations = target.minOperations(nums);
        assertEquals(3, operations);
    }

    @Test
    public void test4() throws Exception {
        int[] nums = new int[]{1, 2, 3, 5, 5, 5};
        int operations = target.minOperations(nums);
        assertEquals(2, operations);
    }
}
