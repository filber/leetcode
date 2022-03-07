package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _1940_LongestCommonSubsequenceBetweenSortedArraysTest {

    _1940_LongestCommonSubsequenceBetweenSortedArrays target = null;

    @Before
    public void before() throws Exception {
        target = new _1940_LongestCommonSubsequenceBetweenSortedArrays();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLongestCommonSubsequences1() throws Exception {
        List<Integer> subsequence = target.longestCommonSubsequences(new int[][]{{1, 3, 4}, {1, 4, 7, 9}});
        assertArrayEquals(new Integer[]{1, 4}, subsequence.toArray(new Integer[0]));
    }

    @Test
    public void testLongestCommonSubsequences2() throws Exception {
        List<Integer> subsequence = target.longestCommonSubsequences(
                new int[][]{
                        {2, 3, 6, 8},
                        {1, 2, 3, 5, 6, 7, 10},
                        {2, 3, 4, 6, 9}});
        assertArrayEquals(new Integer[]{2, 3, 6}, subsequence.toArray(new Integer[0]));
    }

    @Test
    public void testLongestCommonSubsequences3() throws Exception {
        List<Integer> subsequence = target.longestCommonSubsequences(
                new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8}});
        assertTrue(subsequence.isEmpty());
    }
}
