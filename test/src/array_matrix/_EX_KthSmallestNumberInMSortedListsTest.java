package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_KthSmallestNumberInMSortedListsTest {

    _EX_KthSmallestNumberInMSortedLists target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_KthSmallestNumberInMSortedLists();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKthSmallest1() throws Exception {
        int[][] arr = {
                {1, 3},
                {2, 4, 6},
                {0, 9, 10, 11}
        };
        assertEquals(4, target.kthSmallest(arr, 5));
        assertEquals(0, target.kthSmallest(arr, 1));
        assertEquals(1, target.kthSmallest(arr, 2));
        assertEquals(10, target.kthSmallest(arr, 8));
        assertEquals(11, target.kthSmallest(arr, 9));
    }


    @Test
    public void testKthSmallest2() throws Exception {
        int[][] arr = {
                {1, 3, 20},
                {2, 4, 6}};
        assertEquals(1, target.kthSmallest(arr, 1));
        assertEquals(2, target.kthSmallest(arr, 2));
        assertEquals(3, target.kthSmallest(arr, 3));
        assertEquals(4, target.kthSmallest(arr, 4));
        assertEquals(6, target.kthSmallest(arr, 5));
        assertEquals(20, target.kthSmallest(arr, 6));
    }
}
