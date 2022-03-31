package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _410_SplitArrayLargestSumTest {

    _410_SplitArrayLargestSum target = null;

    @Before
    public void before() throws Exception {
        target = new _410_SplitArrayLargestSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSplitArray1() throws Exception {
        int max = target.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        assertEquals(18, max);
    }

    @Test
    public void testSplitArray2() throws Exception {
        int max = target.splitArray(new int[]{1, 2, 3, 4, 5}, 2);
        assertEquals(9, max);
    }

    @Test
    public void testSplitArray3() throws Exception {
        int max = target.splitArray(new int[]{1, 4, 4}, 3);
        assertEquals(4, max);
    }
}
