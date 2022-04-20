package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _373_FindKPairsWithSmallestSumsTest {

    _373_FindKPairsWithSmallestSums target = null;

    @Before
    public void before() throws Exception {
        target = new _373_FindKPairsWithSmallestSums();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testKSmallestPairs1() throws Exception {
        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};
        int k = 9;
        List<List<Integer>> list = target.kSmallestPairs(A, B, k);
        assertEquals(k, list.size());
        int i = 0;
        assertArrayEquals(new Integer[]{1, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 4}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 6}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{7, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{7, 4}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{11, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{7, 6}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{11, 4}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{11, 6}, list.get(i).toArray(new Integer[0]));
    }

    @Test
    public void testKSmallestPairs2() throws Exception {
        int[] A = {1, 1, 2};
        int[] B = {1, 2, 3};
        int k = 9;
        List<List<Integer>> list = target.kSmallestPairs(A, B, k);
        assertEquals(k, list.size());
        int i = 0;
        assertArrayEquals(new Integer[]{1, 1}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 1}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 1}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 3}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 3}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 2}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 3}, list.get(i).toArray(new Integer[0]));
    }

    @Test
    public void testKSmallestPairs3() throws Exception {
        int[] A = {1, 2};
        int[] B = {3};
        int k = 3;
        List<List<Integer>> list = target.kSmallestPairs(A, B, k);
        assertEquals(2, list.size());
        int i = 0;
        assertArrayEquals(new Integer[]{1, 3}, list.get(i++).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 3}, list.get(i).toArray(new Integer[0]));
    }
} 
