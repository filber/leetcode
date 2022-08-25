package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_PlaceLampTest {

    _EX_PlaceLamp target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_PlaceLamp();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPlaceLamp1() throws Exception {
        int[] objects = new int[]{-5, 3, 4, 9};
        int radius = 5;
        int pos = target.placeLamp(objects, radius);
        assertEquals(-1, pos);
    }

    @Test
    public void testPlaceLamp2() throws Exception {
        int[] objects = new int[]{-5};
        int radius = 5;
        int pos = target.placeLamp(objects, radius);
        assertEquals(-10, pos);
    }
}
