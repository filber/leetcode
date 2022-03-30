package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _977_SquaresOfASortedArrayTest {

    _977_SquaresOfASortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _977_SquaresOfASortedArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSortedSquares1() throws Exception {
        int[] squares = target.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, squares);
    }

    @Test
    public void testSortedSquares2() throws Exception {
        int[] squares = target.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, squares);
    }
}
