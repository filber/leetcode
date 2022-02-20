package greedy;

import greedy._56_MergeIntervals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _56_MergeIntervalsTest {

    _56_MergeIntervals target = null;

    @Before
    public void before() throws Exception {
        target = new _56_MergeIntervals();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMerge1() throws Exception {
        int[][] actual = target.merge(new int[][]{{1, 4}, {0, 4}});
        int[][] expected = new int[][]{{0, 4}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge2() throws Exception {
        int[][] actual = target.merge(new int[][]{{1, 2}});
        int[][] expected = new int[][]{{1, 2}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge3() throws Exception {
        int[][] actual = target.merge(new int[][]{{1, 3}, {4, 5}});
        int[][] expected = new int[][]{{1, 3}, {4, 5}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge4() throws Exception {
        int[][] actual = target.merge(new int[][]{{1, 4}, {4, 5}});
        int[][] expected = new int[][]{{1, 5}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge5() throws Exception {
        int[][] actual = target.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge6() throws Exception {
        int[][] actual = target.merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}});
        int[][] expected = new int[][]{{1, 3}, {4, 7}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testMerge7() throws Exception {
        int[][] actual = target.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
        int[][] expected = new int[][]{{1, 10}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}
