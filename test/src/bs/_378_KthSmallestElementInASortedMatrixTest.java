package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _378_KthSmallestElementInASortedMatrixTest {

    _378_KthSmallestElementInASortedMatrix target = null;

    @Before
    public void before() throws Exception {
        target = new _378_KthSmallestElementInASortedMatrix();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKthSmallest1() throws Exception {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        assertEquals(13, target.kthSmallest(matrix, 8));
        assertEquals(15, target.kthSmallest(matrix, 9));
        assertEquals(12, target.kthSmallest(matrix, 6));
        assertEquals(11, target.kthSmallest(matrix, 5));
        assertEquals(10, target.kthSmallest(matrix, 4));
        assertEquals(9, target.kthSmallest(matrix, 3));
        assertEquals(5, target.kthSmallest(matrix, 2));
        assertEquals(1, target.kthSmallest(matrix, 1));
    }

    @Test
    public void testKthSmallest2() throws Exception {
        int[][] matrix = {
                {-5, -4},
                {-5, -4},
        };
        assertEquals(-5, target.kthSmallest(matrix, 1));
        assertEquals(-5, target.kthSmallest(matrix, 2));
        assertEquals(-4, target.kthSmallest(matrix, 3));
        assertEquals(-4, target.kthSmallest(matrix, 4));
    }

    @Test
    public void testKthSmallest5() throws Exception {
        int[][] matrix = {
                {-5},
        };
        int k = 1;
        int num = target.kthSmallest(matrix, k);
        assertEquals(-5, num);
    }

    @Test
    public void testCount() throws Exception {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertEquals(0, target.count(matrix, 0));
        assertEquals(1, target.count(matrix, 1));
        assertEquals(3, target.count(matrix, 3));
        assertEquals(16, target.count(matrix, 16));
        assertEquals(19, target.count(matrix, 20));
        assertEquals(23, target.count(matrix, 25));
    }

} 
