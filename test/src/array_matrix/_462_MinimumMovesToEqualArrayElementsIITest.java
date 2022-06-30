package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _462_MinimumMovesToEqualArrayElementsIITest {

    _462_MinimumMovesToEqualArrayElementsII target = null;

    @Before
    public void before() throws Exception {
        target = new _462_MinimumMovesToEqualArrayElementsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinMoves1() throws Exception {
        int[] nums = {1, 2, 3};
        int moves = target.minMoves2(nums);
        // 2
        assertEquals(2, moves);
    }

    @Test
    public void testMinMoves2() throws Exception {
        // 5 [4,5,3,4]
        int[] nums = {1, 10, 2, 9};
        int moves = target.minMoves2(nums);

        assertEquals(16, moves);
    }

    @Test
    public void testMinMoves3() throws Exception {
        //  1 [0, 1, 1, 7, 5]
        int[] nums = {1, 0, 0, 8, 6};
        int moves = target.minMoves2(nums);
        assertEquals(14, moves);
    }
}
