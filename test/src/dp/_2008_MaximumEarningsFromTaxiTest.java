package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2008_MaximumEarningsFromTaxiTest {

    _2008_MaximumEarningsFromTaxi target = null;

    @Before
    public void before() throws Exception {
        target = new _2008_MaximumEarningsFromTaxi();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxTaxiEarnings1() throws Exception {
        int n = 5;
        int[][] rides = {{2, 5, 4}, {1, 5, 1}};
        long earnings = target.maxTaxiEarnings(n, rides);
        assertEquals(7, earnings);
    }

    @Test
    public void testMaxTaxiEarnings2() throws Exception {
        int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        long earnings = target.maxTaxiEarnings(n, rides);
        // {3, 10, 2} = 9
        // {10, 12, 3} = 5
        //  {13, 18, 1} = 6
        assertEquals(20, earnings);
    }
}
