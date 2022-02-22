package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _84_LargestRectangleInHistogramTest {

    _84_LargestRectangleInHistogram target = null;

    @Before
    public void before() throws Exception {
        target = new _84_LargestRectangleInHistogram();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLargestRectangleArea1() throws Exception {
        // [2,4], [4]
        int area = target.largestRectangleArea(new int[]{2, 4});
        assertEquals(4, area);
    }

    @Test
    public void testLargestRectangleArea2() throws Exception {
        // [5,6]
        int area = target.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        assertEquals(10, area);
    }

    @Test
    public void testLargestRectangleArea3() throws Exception {
        // [2,1,2]
        int area = target.largestRectangleArea(new int[]{2, 1, 2});
        assertEquals(3, area);
    }
}
