package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_CountOfSubsetsWithSumEqualToXTest {

    _EX_CountOfSubsetsWithSumEqualToX target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_CountOfSubsetsWithSumEqualToX();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindCnt1() throws Exception {
        int[] nums = {1, 2, 3, 3};
        int X = 6;
        int count = target.findCnt(nums, X);
        //[1,2,3]*2, [3,3]
        assertEquals(3, count);
    }

    @Test
    public void testFindCnt2() throws Exception {
        int[] nums = {1, 1, 1, 1};
        int X = 1;
        int count = target.findCnt(nums, X);
        assertEquals(4, count);
    }

    @Test
    public void testFindCnt3() throws Exception {
        int[] nums = {1, 1, 1, 1};
        int X = 2;
        int count = target.findCnt(nums, X);
        assertEquals(6, count);
    }

    @Test
    public void testFindCnt4() throws Exception {
        int[] nums = {1, 1, 1, 1};
        int X = 3;
        int count = target.findCnt(nums, X);
        assertEquals(4, count);
    }
}
