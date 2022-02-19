package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1710_MaximumUnitsOnATruckTest {

    _1710_MaximumUnitsOnATruck target = null;

    @Before
    public void before() throws Exception {
        target = new _1710_MaximumUnitsOnATruck();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaximumUnits1() throws Exception {
        // 1*[3] + 2*[2] + 1*[1]
        int units = target.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);
        assertEquals(8, units);
    }

    @Test
    public void testMaximumUnits2() throws Exception {
        // 5*[10] + 3*[9] + 2*[7]
        int units = target.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10);
        assertEquals(91, units);
    }
} 
