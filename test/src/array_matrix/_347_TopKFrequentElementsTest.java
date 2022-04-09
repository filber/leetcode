package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _347_TopKFrequentElementsTest {

    _347_TopKFrequentElements target = null;

    @Before
    public void before() throws Exception {
        target = new _347_TopKFrequentElements();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTopKFrequent1() throws Exception {
        int[] ans = target.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertArrayEquals(new int[]{1, 2}, ans);
    }

    @Test
    public void testTopKFrequent2() throws Exception {
        int[] ans = target.topKFrequent(new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, ans);
    }

    @Test
    public void testTopKFrequent3() throws Exception {
        int[] ans = target.topKFrequent(new int[]{1, 1, 2, 2, 3}, 2);
        assertArrayEquals(new int[]{1, 2}, ans);
    }
}
