package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_MinimumSubsetSumDifferenceTest {

    _EX_MinimumSubsetSumDifference target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_MinimumSubsetSumDifference();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinSumDiff1() throws Exception {
        // [1,5,6] vs [11]
        int diff = target.minSumDiff(new int[]{1, 6, 11, 5});
        assertEquals(1, diff);
    }

    @Test
    public void testMinSumDiff2() throws Exception {
        // [1,5,6] vs [12]
        int diff = target.minSumDiff(new int[]{1, 6, 12, 5});
        assertEquals(0, diff);
    }

    @Test
    public void testMinSumDiff3() throws Exception {
        // [1,2,3] vs [5]
        int diff = target.minSumDiff(new int[]{1, 2, 3, 5});
        assertEquals(1, diff);
    }

    @Test
    public void testMinSumDiff4() throws Exception {
        // [1,4] vs [2,3]
        int diff = target.minSumDiff(new int[]{1, 2, 3, 4});
        assertEquals(0, diff);
    }

    @Test
    public void testMinSumDiff5() throws Exception {
        // [1] vs [2]
        int diff = target.minSumDiff(new int[]{1, 2});
        assertEquals(1, diff);
    }
}
