package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _473_MatchsticksToSquareTest {

    _473_MatchsticksToSquare target = null;

    @Before
    public void before() throws Exception {
        target = new _473_MatchsticksToSquare();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMakesquare1() throws Exception {
        boolean square = target.makesquare(new int[]{1, 1, 2, 2, 2});
        assertTrue(square);
    }

    @Test
    public void testMakesquare2() throws Exception {
        boolean square = target.makesquare(new int[]{3, 3, 3, 3, 4});
        assertFalse(square);
    }
}
