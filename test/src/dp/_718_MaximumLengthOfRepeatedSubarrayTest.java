package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _718_MaximumLengthOfRepeatedSubarrayTest {

    _718_MaximumLengthOfRepeatedSubarray target = null;

    @Before
    public void before() throws Exception {
        target = new _718_MaximumLengthOfRepeatedSubarray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindLength1() throws Exception {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        // [3,2,1]
        int len = target.findLength(A, B);
        assertEquals(3, len);
    }

    @Test
    public void testFindLength2() throws Exception {
        int[] A = {0, 0, 0, 0, 0};
        int[] B = {0, 0, 0, 0, 0};
        // [0,0,0,0,0]
        int len = target.findLength(A, B);
        assertEquals(5, len);
    }

    @Test
    public void testFindLength3() throws Exception {
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};
        // []
        int len = target.findLength(A, B);
        assertEquals(0, len);
    }

    @Test
    public void testFindLength4() throws Exception {
        int[] A = {1, 2, 3};
        int[] B = {4, 2, 6};
        // [2]
        int len = target.findLength(A, B);
        assertEquals(1, len);
    }

    @Test
    public void testFindLength5() throws Exception {
        int[] A = {0, 1, 1, 1, 1};
        int[] B = {1, 0, 1, 0, 1};
        // [0,1]
        int len = target.findLength(A, B);
        assertEquals(2, len);
    }
}
