package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _11_Container_With_Most_WaterTest {

    _11_Container_With_Most_Water target = null;

    @Before
    public void before() throws Exception {
        target = new _11_Container_With_Most_Water();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxArea1() throws Exception {
        int area = target.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(49, area);
    }

    @Test
    public void testMaxArea2() throws Exception {
        int area = target.maxArea(new int[]{1, 1});
        assertEquals(1, area);
    }

    @Test
    public void testMaxArea3() throws Exception {
        int area = target.maxArea(new int[]{10, 14, 10, 4, 10, 2, 6, 1, 6, 12});
        assertEquals(96, area);
    }

    @Test
    public void testMaxArea4() throws Exception {
        int area = target.maxArea(new int[]{1, 2, 4, 3});
        assertEquals(4, area);
    }

    @Test
    public void testMaxArea5() throws Exception {
        int area = target.maxArea(new int[]{1, 3, 2, 5, 25, 24, 5});
        assertEquals(24, area);
    }
}
