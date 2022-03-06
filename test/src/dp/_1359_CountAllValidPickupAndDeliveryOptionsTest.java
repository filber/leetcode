package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1359_CountAllValidPickupAndDeliveryOptionsTest {

    _1359_CountAllValidPickupAndDeliveryOptions target = null;

    @Before
    public void before() throws Exception {
        target = new _1359_CountAllValidPickupAndDeliveryOptions();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountOrders1() throws Exception {
        int cnt = target.countOrders(1);
        assertEquals(1, cnt);
    }

    @Test
    public void testCountOrders2() throws Exception {
        int cnt = target.countOrders(2);
        assertEquals(6, cnt);
    }

    @Test
    public void testCountOrders3() throws Exception {
        int cnt = target.countOrders(3);
        assertEquals(90, cnt);
    }

    @Test
    public void testCountOrders8() throws Exception {
        int cnt = target.countOrders(8);
        assertEquals(729647433, cnt);
    }

    @Test
    public void testCountOrders9() throws Exception {
        int cnt = target.countOrders(9);
        assertEquals(636056472, cnt);
    }

    @Test
    public void testCountOrders500() throws Exception {
        int cnt = target.countOrders(500);
        assertEquals(764678010, cnt);
    }

}
