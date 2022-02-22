package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _739_DailyTemperaturesTest {

    _739_DailyTemperatures target = null;

    @Before
    public void before() throws Exception {
        target = new _739_DailyTemperatures();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDailyTemperatures1() throws Exception {
        int[] waits = target.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, waits);
    }

    @Test
    public void testDailyTemperatures2() throws Exception {
        int[] waits = target.dailyTemperatures(new int[]{30, 40, 50, 60});
        assertArrayEquals(new int[]{1, 1, 1, 0}, waits);
    }

    @Test
    public void testDailyTemperatures3() throws Exception {
        int[] waits = target.dailyTemperatures(new int[]{30, 60, 90});
        assertArrayEquals(new int[]{1, 1, 0}, waits);
    }

    @Test
    public void testDailyTemperatures4() throws Exception {
        int[] waits = target.dailyTemperatures(new int[]{30, 30, 29});
        assertArrayEquals(new int[]{0, 0, 0}, waits);
    }

    @Test
    public void testDailyTemperatures5() throws Exception {
        int[] waits = target.dailyTemperatures(new int[]{30});
        assertArrayEquals(new int[]{0}, waits);
    }

} 
