package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _453_MinimumMovesToEqualArrayElementsTest {

    _453_MinimumMovesToEqualArrayElements target = null;

    @Before
    public void before() throws Exception {
        target = new _453_MinimumMovesToEqualArrayElements();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinMoves1() throws Exception {
        int[] nums = {1, 2, 3};
        int moves = target.minMoves(nums);
        assertEquals(3, moves);
    }

    @Test
    public void testMinMoves2() throws Exception {
        int[] nums = {1, 1, 1};
        int moves = target.minMoves(nums);
        assertEquals(0, moves);
    }
}
