package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _787_CheapestFlightsWithinKStopsTest {

    _787_CheapestFlightsWithinKStops target = null;

    @Before
    public void before() throws Exception {
        target = new _787_CheapestFlightsWithinKStops();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindCheapestPrice1() throws Exception {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int price = target.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(700, price);
    }

    @Test
    public void testFindCheapestPrice2() throws Exception {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int price = target.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(200, price);
    }

    @Test
    public void testFindCheapestPrice3() throws Exception {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 0;
        int price = target.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(500, price);
    }

    @Test
    public void testFindCheapestPrice4() throws Exception {
        int n = 5;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        int price = target.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(7, price);
    }
}
