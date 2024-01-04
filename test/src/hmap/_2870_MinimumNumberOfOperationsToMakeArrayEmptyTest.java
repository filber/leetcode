package hmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2870_MinimumNumberOfOperationsToMakeArrayEmptyTest {

    _2870_MinimumNumberOfOperationsToMakeArrayEmpty target;

    @Before
    public void setUp() throws Exception {
        target = new _2870_MinimumNumberOfOperationsToMakeArrayEmpty();
    }

    @Test
    public void testMinOperations1() {
        int[] nums = {2, 3, 3, 2, 2, 4, 2, 3, 4};
        int operations = target.minOperations(nums);
        assertEquals(4, operations);
    }

    @Test
    public void testMinOperations2() {
        int[] nums = {2, 1, 2, 2, 3, 3};
        int operations = target.minOperations(nums);
        assertEquals(-1, operations);
    }

    @Test
    public void testMinOperations3() {
        int[] nums = {2, 2, 2, 2, 3, 3};
        int operations = target.minOperations(nums);
        assertEquals(3, operations);
    }

    @Test
    public void testMinOperations4() {
        int[] nums = {2, 2, 2, 2, 2};
        int operations = target.minOperations(nums);
        assertEquals(2, operations);
    }

    @Test
    public void testMinOperations5() {
        int[] nums = {2, 2, 2, 2, 2, 2, 2};
        int operations = target.minOperations(nums);
        assertEquals(3, operations);
    }

    @Test
    public void testMinOperations6() {
        int[] nums = {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
        int operations = target.minOperations(nums);
        assertEquals(7, operations);
    }

}