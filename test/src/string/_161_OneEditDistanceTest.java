package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _161_OneEditDistanceTest {

    _161_OneEditDistance target = null;

    @Before
    public void before() throws Exception {
        target = new _161_OneEditDistance();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsOneEditDistance1() throws Exception {
        boolean res = target.isOneEditDistance("ab", "acb");
        assertTrue(res);
    }

    @Test
    public void testIsOneEditDistance2() throws Exception {
        boolean res = target.isOneEditDistance("cab", "ad");
        assertFalse(res);
    }

    @Test
    public void testIsOneEditDistance3() throws Exception {
        boolean res = target.isOneEditDistance("1203", "1213");
        assertTrue(res);
    }

    @Test
    public void testIsOneEditDistance4() throws Exception {
        boolean res = target.isOneEditDistance("1204", "1213");
        assertFalse(res);
    }

    @Test
    public void testIsOneEditDistance5() throws Exception {
        boolean res = target.isOneEditDistance("12", "1213");
        assertFalse(res);
    }

    @Test
    public void testIsOneEditDistance6() throws Exception {
        boolean res = target.isOneEditDistance("abcde", "acde");
        assertTrue(res);
    }

    @Test
    public void testIsOneEditDistance7() throws Exception {
        boolean res = target.isOneEditDistance("abcdf", "acde");
        assertFalse(res);
    }
}
