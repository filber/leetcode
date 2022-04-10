package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _682_BaseballGameTest {

    _682_BaseballGame target = null;

    @Before
    public void before() throws Exception {
        target = new _682_BaseballGame();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCalPoints1() throws Exception {
        int score = target.calPoints(new String[]{"5", "2", "C", "D", "+"});
        assertEquals(30, score);
    }

    @Test
    public void testCalPoints2() throws Exception {
        int score = target.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"});
        assertEquals(27, score);
    }

    @Test
    public void testCalPoints3() throws Exception {
        int score = target.calPoints(new String[]{"1"});
        assertEquals(1, score);
    }
}
