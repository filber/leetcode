package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _581_ShortestUnsortedContinuousSubarrayTest {

    _581_ShortestUnsortedContinuousSubarray target = null;

    @Before
    public void before() throws Exception {
        target = new _581_ShortestUnsortedContinuousSubarray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindUnsortedSubarray1() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        // [6, 4, 8, 10, 9]
        assertEquals(5, len);
    }

    @Test
    public void testFindUnsortedSubarray2() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1, 2, 3, 4});
        assertEquals(0, len);
    }

    @Test
    public void testFindUnsortedSubarray3() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1});
        assertEquals(0, len);
    }

    @Test
    public void testFindUnsortedSubarray4() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2});
        //[3, 2, 2, 2]
        assertEquals(4, len);
    }

    @Test
    public void testFindUnsortedSubarray5() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1, 3, 2, 2, 4, 5, 6});
        //[3, 2, 2]
        assertEquals(3, len);
    }

    @Test
    public void testFindUnsortedSubarray6() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1, 3, 2, 2, 4, 4, 4});
        //[3, 2, 2]
        assertEquals(3, len);
    }

    @Test
    public void testFindUnsortedSubarray7() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{2, 2, 2, 1, 1});
        //[2, 2, 2, 1, 1]
        assertEquals(5, len);
    }

    @Test
    public void testFindUnsortedSubarray8() throws Exception {
        int len = target.findUnsortedSubarray(new int[]{1});
        assertEquals(0, len);
    }
}
