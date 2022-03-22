package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1575_CountAllPossibleRoutesTest {

    _1575_CountAllPossibleRoutes target = null;

    @Before
    public void before() throws Exception {
        target = new _1575_CountAllPossibleRoutes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountRoutes1() throws Exception {
        int routes = target.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5);
        assertEquals(4, routes);
    }

    @Test
    public void testCountRoutes2() throws Exception {
        int routes = target.countRoutes(new int[]{4, 3, 1}, 1, 0, 6);
        assertEquals(5, routes);
    }

    @Test
    public void testCountRoutes3() throws Exception {
        int routes = target.countRoutes(new int[]{5, 2, 1}, 0, 2, 3);
        assertEquals(0, routes);
    }
}
