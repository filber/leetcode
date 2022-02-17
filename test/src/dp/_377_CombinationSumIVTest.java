package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _377_CombinationSumIVTest {

    _377_CombinationSumIV target = null;

    @Before
    public void before() throws Exception {
        target = new _377_CombinationSumIV();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCombinationSum1() throws Exception {
        int c = target.combinationSum4(new int[]{1, 2, 3}, 4);
        assertEquals(7, c);
    }

    @Test
    public void testCombinationSum2() throws Exception {
        int c = target.combinationSum4(new int[]{9}, 3);
        assertEquals(0, c);
    }

} 
