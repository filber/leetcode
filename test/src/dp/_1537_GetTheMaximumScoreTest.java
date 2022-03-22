package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1537_GetTheMaximumScoreTest {

    _1537_GetTheMaximumScore target = null;

    @Before
    public void before() throws Exception {
        target = new _1537_GetTheMaximumScore();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxSum1() throws Exception {
        int score = target.maxSum(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9});
        // [2,4,6,8,10]
        assertEquals(30, score);
    }

    @Test
    public void testMaxSum2() throws Exception {
        int score = target.maxSum(new int[]{1, 3, 5, 7, 9}, new int[]{3, 5, 100});
        // [1,3,5,100]
        assertEquals(109, score);
    }

    @Test
    public void testMaxSum3() throws Exception {
        int score = target.maxSum(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10});
        // [6,7,8,9,10]
        assertEquals(40, score);
    }

    @Test
    public void testMaxSum4() throws Exception {
        int score = target.maxSum(new int[]{5}, new int[]{1, 2, 3});
        // [1,2,3]
        assertEquals(6, score);
    }

    @Test
    public void testMaxSum5() throws Exception {
        int score = target.maxSum(new int[]{1, 6}, new int[]{1, 2, 3});
        // [1,6]
        assertEquals(7, score);
    }

    @Test
    public void testMaxSum6() throws Exception {
        int score = target.maxSum(new int[]{1, 2, 4, 8}, new int[]{2, 3, 4, 5});
        // [1,2,4,8]
        assertEquals(18, score);
    }
}
