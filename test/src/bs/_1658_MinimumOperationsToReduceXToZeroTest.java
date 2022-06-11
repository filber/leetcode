package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1658_MinimumOperationsToReduceXToZeroTest {

    _1658_MinimumOperationsToReduceXToZero target = null;

    @Before
    public void before() throws Exception {
        target = new _1658_MinimumOperationsToReduceXToZero();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinOperations1() throws Exception {
        int[] nums = new int[]{1, 1, 4, 2, 3};
        int x = 5;
        int operations = target.minOperations(nums, x);
        assertEquals(2, operations);
    }

    @Test
    public void testMinOperations2() throws Exception {
        int[] nums = new int[]{5, 6, 7, 8, 9};
        int x = 4;
        int operations = target.minOperations(nums, x);
        assertEquals(-1, operations);
    }

    @Test
    public void testMinOperations3() throws Exception {
        int[] nums = new int[]{3, 2, 20, 1, 1, 3};
        int x = 10;
        int operations = target.minOperations(nums, x);
        assertEquals(5, operations);
    }

    @Test
    public void testMinOperations4() throws Exception {
        int[] nums = new int[]{5, 2, 3, 1, 1};
        int x = 5;
        int operations = target.minOperations(nums, x);
        assertEquals(1, operations);
    }
}
