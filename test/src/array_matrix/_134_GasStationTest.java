package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _134_GasStationTest {

    _134_GasStation target = null;

    @Before
    public void before() throws Exception {
        target = new _134_GasStation();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCanCompleteCircuit1() throws Exception {
        int start = target.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        assertEquals(3, start);
    }

    @Test
    public void testCanCompleteCircuit2() throws Exception {
        int start = target.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        assertEquals(-1, start);
    }
}
