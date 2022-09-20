package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2104_SumOfSubarrayRangesTest {

    _2104_SumOfSubarrayRanges target = null;

    @Before
    public void before() throws Exception {
        target = new _2104_SumOfSubarrayRanges();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSubArrayRanges1() throws Exception {
        int[] arr = {1, 2, 3};
        long sum = target.subArrayRanges(arr);
        //[1,2]=1,[2,3]=1
        //[1,2,3]=2
        assertEquals(4, sum);
    }

    @Test
    public void testSubArrayRanges2() throws Exception {
        int[] arr = {1, 3, 3};
        long sum = target.subArrayRanges(arr);
        //[1,3]=2,[3,3]=0
        //[1,3,3]=2
        assertEquals(4, sum);
    }

    @Test
    public void testSubArrayRanges3() throws Exception {
        int[] arr = {4, -2, -3, 4, 1};
        long sum = target.subArrayRanges(arr);
        assertEquals(59, sum);
    }
}
