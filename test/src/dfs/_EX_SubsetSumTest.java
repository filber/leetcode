package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_SubsetSumTest {

    _EX_SubsetSum target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_SubsetSum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsSubsetSum1() throws Exception {
        assertTrue(target.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
    }

    @Test
    public void testIsSubsetSum2() throws Exception {
        assertFalse(target.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }

    @Test
    public void testIsSubsetSum3() throws Exception {
        assertTrue(target.isSubsetSum(new int[]{3, 4, 5, 2}, 9));
    }

    @Test
    public void testIsSubsetSum4() throws Exception {
        assertFalse(target.isSubsetSum(new int[]{3, 4, 5, 2}, 1));
    }

    @Test
    public void testIsSubsetSum5() throws Exception {
        assertTrue(target.isSubsetSum(new int[]{3, 4, 5, 2}, 11));
    }
}
