package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsTest {

    _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts target = null;

    @Before
    public void before() throws Exception {
        target = new _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxArea1() throws Exception {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        int maxArea = target.maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(4, maxArea);
    }

    @Test
    public void testMaxArea2() throws Exception {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3, 1};
        int[] verticalCuts = {1};
        int maxArea = target.maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(6, maxArea);
    }

    @Test
    public void testMaxArea3() throws Exception {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3};
        int[] verticalCuts = {3};
        int maxArea = target.maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(9, maxArea);
    }

    @Test
    public void testMaxArea4() throws Exception {
        int h = 1000000000;
        int w = 1000000000;
        int[] horizontalCuts = {2};
        int[] verticalCuts = {2};
        int maxArea = target.maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(81, maxArea);
    }
}
