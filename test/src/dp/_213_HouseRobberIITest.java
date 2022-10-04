package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _213_HouseRobberIITest {

    _213_HouseRobberII target = null;

    @Before
    public void before() throws Exception {
        target = new _213_HouseRobberII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRob1() throws Exception {
        int amt = target.rob(new int[]{2, 3, 2});
        //[3]
        assertEquals(3, amt);
    }

    @Test
    public void testRob2() throws Exception {
        int amt = target.rob(new int[]{1, 2, 3, 1});
        //[1,3]
        assertEquals(4, amt);
    }

    @Test
    public void testRob3() throws Exception {
        int amt = target.rob(new int[]{1, 2, 3});
        //[3]
        assertEquals(3, amt);
    }
}
