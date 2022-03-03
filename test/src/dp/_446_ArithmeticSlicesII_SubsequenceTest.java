package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _446_ArithmeticSlicesII_SubsequenceTest {

    _446_ArithmeticSlicesII_Subsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _446_ArithmeticSlicesII_Subsequence();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumberOfArithmeticSlices1() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
        assertEquals(7, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices2() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7});
        assertEquals(16, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices3() throws Exception {
        //[1,1,1]
        int cnt = target.numberOfArithmeticSlices(new int[]{1, 2, 1, 2, 4, 1, 5, 10});
        assertEquals(1, cnt);
    }
}
