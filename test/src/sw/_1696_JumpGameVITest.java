package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1696_JumpGameVITest {

    _1696_JumpGameVI target = null;

    @Before
    public void before() throws Exception {
        target = new _1696_JumpGameVI();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxResult1() throws Exception {
        int score = target.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
        assertEquals(7, score);
    }

    @Test
    public void testMaxResult2() throws Exception {
        int score = target.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
        assertEquals(17, score);
    }

    @Test
    public void testMaxResult3() throws Exception {
        int score = target.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2);
        assertEquals(0, score);
    }
}
