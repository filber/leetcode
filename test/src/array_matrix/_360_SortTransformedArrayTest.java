package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _360_SortTransformedArrayTest {

    _360_SortTransformedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _360_SortTransformedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSortTransformedArray1() throws Exception {
        int[] arr = target.sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5);
        assertArrayEquals(new int[]{3, 9, 15, 33}, arr);
    }

    @Test
    public void testSortTransformedArray2() throws Exception {
        int[] arr = target.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5);
        assertArrayEquals(new int[]{-23, -5, 1, 7}, arr);
    }
}
