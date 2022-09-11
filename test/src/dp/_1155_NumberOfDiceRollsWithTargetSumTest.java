package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1155_NumberOfDiceRollsWithTargetSumTest {

    _1155_NumberOfDiceRollsWithTargetSum target = null;

    @Before
    public void before() throws Exception {
        target = new _1155_NumberOfDiceRollsWithTargetSum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumRollsToTarget1() throws Exception {
        int n = 1;
        int k = 6;
        int t = 3;
        int num = target.numRollsToTarget(n, k, t);
        assertEquals(1, num);
    }

    @Test
    public void testNumRollsToTarget2() throws Exception {
        int n = 2;
        int k = 6;
        int t = 7;
        int num = target.numRollsToTarget(n, k, t);
        // 1+6, 2+5, 3+4, 4+3, 5+2, 6+1
        assertEquals(6, num);
    }

    @Test
    public void testNumRollsToTarget3() throws Exception {
        int n = 30;
        int k = 30;
        int t = 500;
        int num = target.numRollsToTarget(n, k, t);
        assertEquals(222616187, num);
    }
}
