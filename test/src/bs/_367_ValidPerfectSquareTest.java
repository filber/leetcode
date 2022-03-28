package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _367_ValidPerfectSquareTest {

    _367_ValidPerfectSquare target = null;

    @Before
    public void before() throws Exception {
        target = new _367_ValidPerfectSquare();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsPerfectSquare1() throws Exception {
        boolean res = target.isPerfectSquare(1);
        assertTrue(res);
    }

    @Test
    public void testIsPerfectSquare2() throws Exception {
        boolean res = target.isPerfectSquare(4);
        assertTrue(res);
    }

    @Test
    public void testIsPerfectSquare3() throws Exception {
        boolean res = target.isPerfectSquare(16);
        assertTrue(res);
    }

    @Test
    public void testIsPerfectSquare4() throws Exception {
        boolean res = target.isPerfectSquare(14);
        assertFalse(res);
    }

    @Test
    public void testIsPerfectSquare5() throws Exception {
        boolean res = target.isPerfectSquare(20);
        assertFalse(res);
    }
}
