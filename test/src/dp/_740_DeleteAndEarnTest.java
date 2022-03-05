package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _740_DeleteAndEarnTest {

    _740_DeleteAndEarn target = null;

    @Before
    public void before() throws Exception {
        target = new _740_DeleteAndEarn();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDeleteAndEarn1() throws Exception {
        int points = target.deleteAndEarn(new int[]{3, 4, 2});
        assertEquals(6, points);
    }

    @Test
    public void testDeleteAndEarn2() throws Exception {
        int points = target.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
        assertEquals(9, points);
    }
}
