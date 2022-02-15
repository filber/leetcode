package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1863_SumofAllSubsetXORTotalsTest {

    _1863_SumofAllSubsetXORTotals target = null;

    @Before
    public void before() throws Exception {
        target = new _1863_SumofAllSubsetXORTotals();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSubsetXORSum1() throws Exception {
        int sum = target.subsetXORSum(new int[]{1, 3});
        assertEquals(6, sum);
    }

    @Test
    public void testSubsetXORSum2() throws Exception {
        int sum = target.subsetXORSum(new int[]{5, 1, 6});
        assertEquals(28, sum);
    }

    @Test
    public void testSubsetXORSum3() throws Exception {
        int sum = target.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8});
        assertEquals(480, sum);
    }

    @Test
    public void testSubsetXORSum4() throws Exception {
        int sum = target.subsetXORSum(new int[]{1});
        assertEquals(1, sum);
    }

} 
