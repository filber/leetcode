package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1738_FindKthLargestXORCoordinateValueTest {

    _1738_FindKthLargestXORCoordinateValue target;

    @Before
    public void setUp() throws Exception {
        target = new _1738_FindKthLargestXORCoordinateValue();
    }

    @Test
    public void testKthLargestValue1() {
        int[][] matrix = new int[][]{{4}};
        int value = target.kthLargestValue(matrix, 1);
        assertEquals(4, value);
    }

    @Test
    public void testKthLargestValue2() {
        int[][] matrix = new int[][]{{5, 2}, {1, 6}};
        assertEquals(7, target.kthLargestValue(matrix, 1));
        assertEquals(5, target.kthLargestValue(matrix, 2));
        assertEquals(4, target.kthLargestValue(matrix, 3));
    }

    @Test
    public void testKthLargestValue3() {
        int[][] matrix = new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}};
        assertEquals(1, target.kthLargestValue(matrix, 10));
    }
}