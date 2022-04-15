package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _757_SetIntersectionSizeAtLeastTwoTest {

    _757_SetIntersectionSizeAtLeastTwo target = null;

    @Before
    public void before() throws Exception {
        target = new _757_SetIntersectionSizeAtLeastTwo();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIntersectionSizeTwo1() throws Exception {
        // {2,3,4}
        int size = target.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}});
        assertEquals(3, size);
    }

    @Test
    public void testIntersectionSizeTwo2() throws Exception {
        // {1, 2, 3, 4, 5}
        int size = target.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}});
        assertEquals(5, size);
    }

    @Test
    public void testIntersectionSizeTwo3() throws Exception {
        // {1,2,3,4,5,6}
        int size = target.intersectionSizeTwo(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        assertEquals(6, size);
    }

    @Test
    public void testIntersectionSizeTwo4() throws Exception {
        // {1,2}
        int size = target.intersectionSizeTwo(new int[][]{{1, 2}, {1, 3}, {1, 4}});
        assertEquals(2, size);
    }

    @Test
    public void testIntersectionSizeTwo5() throws Exception {
        // {1,2,3}
        int size = target.intersectionSizeTwo(new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}});
        assertEquals(3, size);
    }

    @Test
    public void testIntersectionSizeTwo6() throws Exception {
        // {6,7,8,11,12}
        int size = target.intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}});
        assertEquals(5, size);
    }

    @Test
    public void testIntersectionSizeTwo7() throws Exception {
        // {2,3,5,7,8}
        int size = target.intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {5, 7}, {7, 8}});
        assertEquals(5, size);
    }

    @Test
    public void testIntersectionSizeTwo8() throws Exception {
        // {}
        int size = target.intersectionSizeTwo(new int[][]{{33, 44}, {42, 43}, {13, 37}, {24, 33}, {24, 33}, {25, 48}, {10, 47}, {18, 24}, {29, 37}, {7, 34}});
        assertEquals(6, size);
    }

}
