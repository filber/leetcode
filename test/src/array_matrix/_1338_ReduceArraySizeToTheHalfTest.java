package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1338_ReduceArraySizeToTheHalfTest {

    _1338_ReduceArraySizeToTheHalf target = null;

    @Before
    public void before() throws Exception {
        target = new _1338_ReduceArraySizeToTheHalf();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinSetSize1() throws Exception {
        int size = target.minSetSize(new int[]{1000, 1000, 3, 7});
        // [1000]
        assertEquals(1, size);
    }

    @Test
    public void testMinSetSize2() throws Exception {
        int size = target.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
        // [3,5]
        assertEquals(2, size);
    }

    @Test
    public void testMinSetSize3() throws Exception {
        int size = target.minSetSize(new int[]{7, 7, 7, 7, 7, 7});
        // [7]
        assertEquals(1, size);
    }

    @Test
    public void testMinSetSize4() throws Exception {
        int size = target.minSetSize(new int[]{1, 9});
        // [1]
        assertEquals(1, size);
    }

    @Test
    public void testMinSetSize5() throws Exception {
        int size = target.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        // [1, 2, 3, 4, 5]
        assertEquals(5, size);
    }
}
