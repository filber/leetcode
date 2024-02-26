package union_find;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2709_GreatestCommonDivisorTraversalTest {

    _2709_GreatestCommonDivisorTraversal target;

    @Before
    public void setUp() throws Exception {
        target = new _2709_GreatestCommonDivisorTraversal();
    }

    @Test
    public void testCanTraverseAllPairs1() {
        int[] nums = {2, 3, 6};
        boolean result = target.canTraverseAllPairs(nums);
        assertTrue(result);
    }

    @Test
    public void testCanTraverseAllPairs2() {
        int[] nums = {3, 9, 5};
        boolean result = target.canTraverseAllPairs(nums);
        assertFalse(result);
    }

    @Test
    public void testCanTraverseAllPairs3() {
        int[] nums = {4, 3, 12, 8};
        boolean result = target.canTraverseAllPairs(nums);
        assertTrue(result);
    }
}