package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _869_ReorderedPowerOf2Test {

    _869_ReorderedPowerOf2 target = null;

    @Before
    public void before() throws Exception {
        target = new _869_ReorderedPowerOf2();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testReorderedPowerOf21() throws Exception {
        boolean is = target.reorderedPowerOf2(1);
        assertTrue(is);
    }

    @Test
    public void testReorderedPowerOf22() throws Exception {
        boolean is = target.reorderedPowerOf2(10);
        assertFalse(is);
    }

    @Test
    public void testReorderedPowerOf23() throws Exception {
        boolean is = target.reorderedPowerOf2(46);
        assertTrue(is);
    }
}
