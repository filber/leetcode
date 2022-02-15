package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2044_CountNumberOfMaximumBitwiseORSubsetsTest {

    _2044_CountNumberOfMaximumBitwiseORSubsets target = null;

    @Before
    public void before() throws Exception {
        target = new _2044_CountNumberOfMaximumBitwiseORSubsets();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountMaxOrSubsets1() throws Exception {
        int maxCnt = target.countMaxOrSubsets(new int[]{2, 2, 2});
        assertEquals(7, maxCnt);
    }

    @Test
    public void testCountMaxOrSubsets2() throws Exception {
        int maxCnt = target.countMaxOrSubsets(new int[]{3, 1});
        assertEquals(2, maxCnt);
    }

    @Test
    public void testCountMaxOrSubsets3() throws Exception {
        int maxCnt = target.countMaxOrSubsets(new int[]{3, 2, 1, 5});
        assertEquals(6, maxCnt);
    }
}
