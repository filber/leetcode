package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1235_MaximumProfitInJobSchedulingTest {

    _1235_MaximumProfitInJobScheduling target = null;

    @Before
    public void before() throws Exception {
        target = new _1235_MaximumProfitInJobScheduling();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testJobScheduling1() throws Exception {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        int maxProfit = target.jobScheduling(startTime, endTime, profit);
        assertEquals(120, maxProfit);
    }

    @Test
    public void testJobScheduling2() throws Exception {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        int maxProfit = target.jobScheduling(startTime, endTime, profit);
        assertEquals(150, maxProfit);
    }

    @Test
    public void testJobScheduling3() throws Exception {
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        int maxProfit = target.jobScheduling(startTime, endTime, profit);
        assertEquals(6, maxProfit);
    }
}
