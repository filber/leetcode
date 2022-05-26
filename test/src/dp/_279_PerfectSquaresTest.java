package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _279_PerfectSquaresTest {

    _279_PerfectSquares target = null;

    @Before
    public void before() throws Exception {
        target = new _279_PerfectSquares();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumSquares1() throws Exception {
        int squares = target.numSquares(1);
        assertEquals(1, squares);
    }

    @Test
    public void testNumSquares2() throws Exception {
        // 1 + 1
        int squares = target.numSquares(2);
        assertEquals(2, squares);
    }

    @Test
    public void testNumSquares3() throws Exception {
        // 1 + 1 + 1
        int squares = target.numSquares(3);
        assertEquals(3, squares);
    }

    @Test
    public void testNumSquares4() throws Exception {
        // 4
        int squares = target.numSquares(4);
        assertEquals(1, squares);
    }

    @Test
    public void testNumSquares5() throws Exception {
        // 4 + 4 + 4
        int squares = target.numSquares(12);
        assertEquals(3, squares);
    }

    @Test
    public void testNumSquares6() throws Exception {
        // 9 + 4
        int squares = target.numSquares(13);
        assertEquals(2, squares);
    }

} 
