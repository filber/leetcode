package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _881_BoatsToSavePeopleTest {

    _881_BoatsToSavePeople target = null;

    @Before
    public void before() throws Exception {
        target = new _881_BoatsToSavePeople();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumRescueBoats1() throws Exception {
        int boats = target.numRescueBoats(new int[]{1, 2}, 3);
        assertEquals(1, boats);
    }

    @Test
    public void testNumRescueBoats2() throws Exception {
        int boats = target.numRescueBoats(new int[]{3, 2, 2, 1}, 3);
        assertEquals(3, boats);
    }

    @Test
    public void testNumRescueBoats3() throws Exception {
        int boats = target.numRescueBoats(new int[]{3, 5, 3, 4}, 5);
        assertEquals(4, boats);
    }

    @Test
    public void testNumRescueBoats4() throws Exception {
        int boats = target.numRescueBoats(new int[]{2, 4}, 5);
        assertEquals(2, boats);
    }

    @Test
    public void testNumRescueBoats5() throws Exception {
        int boats = target.numRescueBoats(new int[]{2, 2}, 6); // 1
        assertEquals(1, boats);
    }
}
