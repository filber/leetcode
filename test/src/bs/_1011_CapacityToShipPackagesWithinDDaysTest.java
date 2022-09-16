package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1011_CapacityToShipPackagesWithinDDaysTest {

    _1011_CapacityToShipPackagesWithinDDays target;

    @Before
    public void before() throws Exception {
        target = new _1011_CapacityToShipPackagesWithinDDays();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testShipWithinDays1() throws Exception {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int capacity = target.shipWithinDays(weights, days);
        assertEquals(15, capacity);
    }

    @Test
    public void testShipWithinDays2() throws Exception {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        int capacity = target.shipWithinDays(weights, days);
        assertEquals(6, capacity);
    }

    @Test
    public void testShipWithinDays3() throws Exception {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        int capacity = target.shipWithinDays(weights, days);
        assertEquals(3, capacity);
    }
}
