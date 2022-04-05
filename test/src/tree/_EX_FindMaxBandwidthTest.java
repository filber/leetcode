package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_FindMaxBandwidthTest {

    _EX_FindMaxBandwidth target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_FindMaxBandwidth();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxBandwidth1() throws Exception {
        int maxBandwidth = target.maxBandwidth(new int[][]{
                {1, 30, 2}, {31, 60, 4}, {61, 120, 3},
                {1, 20, 2}, {21, 40, 4}, {41, 60, 5}, {61, 120, 3},
                {1, 60, 4}, {61, 120, 4}});
        assertEquals(13, maxBandwidth);
    }
}
