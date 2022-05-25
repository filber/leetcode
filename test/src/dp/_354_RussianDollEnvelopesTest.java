package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _354_RussianDollEnvelopesTest {

    _354_RussianDollEnvelopes target = null;

    @Before
    public void before() throws Exception {
        target = new _354_RussianDollEnvelopes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxEnvelopes1() throws Exception {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int max = target.maxEnvelopes(envelopes);
        assertEquals(3, max);
    }

    @Test
    public void testMaxEnvelopes2() throws Exception {
        int[][] envelopes = {{1, 1}, {1, 1}, {1, 1}};
        int max = target.maxEnvelopes(envelopes);
        assertEquals(1, max);
    }

    @Test
    public void testMaxEnvelopes3() throws Exception {
        int[][] envelopes = {{1, 1}, {1, 2}, {1, 1}};
        int max = target.maxEnvelopes(envelopes);
        assertEquals(1, max);
    }

    @Test
    public void testMaxEnvelopes4() throws Exception {
        int[][] envelopes = {{1, 1}, {2, 2}, {1, 1}};
        int max = target.maxEnvelopes(envelopes);
        assertEquals(2, max);
    }

    @Test
    public void testMaxEnvelopes5() throws Exception {
        int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        int max = target.maxEnvelopes(envelopes);
        assertEquals(5, max);
    }

}
