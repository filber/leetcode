package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_MaximumDistinctElementsAfterRemovingKElementsTest {

    _EX_MaximumDistinctElementsAfterRemovingKElements target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_MaximumDistinctElementsAfterRemovingKElements();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxDistinctNum1() throws Exception {
        int[] arr = {5, 7, 5, 5, 1, 2, 2};
        int k = 3;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(4, cnt);
    }

    @Test
    public void testMaxDistinctNum2() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 5;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(2, cnt);
    }

    @Test
    public void testMaxDistinctNum3() throws Exception {
        int[] arr = {1, 2, 2, 2};
        int k = 1;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(1, cnt);
    }

    @Test
    public void testMaxDistinctNum4() throws Exception {
        int[] arr = {1, 2, 2, 2};
        int k = 2;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(2, cnt);
    }

    @Test
    public void testMaxDistinctNum5() throws Exception {
        int[] arr = {1, 1, 2, 2, 2};
        int k = 1;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(1, cnt);
    }

    @Test
    public void testMaxDistinctNum6() throws Exception {
        int[] arr = {1, 1, 2, 2, 2};
        int k = 3;
        int cnt = target.maxDistinctNum(arr, k);
        assertEquals(2, cnt);
    }
} 
