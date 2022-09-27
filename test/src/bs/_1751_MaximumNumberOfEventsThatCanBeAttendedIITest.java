package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1751_MaximumNumberOfEventsThatCanBeAttendedIITest {

    _1751_MaximumNumberOfEventsThatCanBeAttendedII target = null;

    @Before
    public void before() throws Exception {
        target = new _1751_MaximumNumberOfEventsThatCanBeAttendedII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxValue1() throws Exception {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int K = 2;
        int value = target.maxValue(events, K);
        assertEquals(7, value);
    }

    @Test
    public void testMaxValue2() throws Exception {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        int K = 2;
        int value = target.maxValue(events, K);
        assertEquals(10, value);
    }

    @Test
    public void testMaxValue3() throws Exception {
        int[][] events = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        int K = 3;
        int value = target.maxValue(events, K);
        assertEquals(9, value);
    }
}
