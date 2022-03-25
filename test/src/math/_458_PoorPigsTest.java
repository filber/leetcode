package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _458_PoorPigsTest {

    _458_PoorPigs target = null;

    @Before
    public void before() throws Exception {
        target = new _458_PoorPigs();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPoorPigs1() throws Exception {
        int pigs = target.poorPigs(1000, 15, 60);
        assertEquals(5, pigs);
    }

    @Test
    public void testPoorPigs2() throws Exception {
        int pigs = target.poorPigs(4, 15, 15);
        assertEquals(2, pigs);
    }

    @Test
    public void testPoorPigs3() throws Exception {
        int pigs = target.poorPigs(4, 15, 30);
        assertEquals(2, pigs);
    }

    @Test
    public void testPoorPigs4() throws Exception {
        int pigs = target.poorPigs(1, 15, 30);
        assertEquals(0, pigs);
    }
}
