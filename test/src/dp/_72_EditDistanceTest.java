package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _72_EditDistanceTest {

    _72_EditDistance target = null;

    @Before
    public void before() throws Exception {
        target = new _72_EditDistance();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinDistance1() throws Exception {
        int distance = target.minDistance("horse", "ros");
        assertEquals(3, distance);
    }

    @Test
    public void testMinDistance2() throws Exception {
        int distance = target.minDistance("intention", "execution");
        assertEquals(5, distance);
    }

    @Test
    public void testMinDistance3() throws Exception {
        int distance = target.minDistance("sea", "eat");
        assertEquals(2, distance);
    }

    @Test
    public void testMinDistance4() throws Exception {
        int distance = target.minDistance("sea", "ate");
        assertEquals(3, distance);
    }
}
