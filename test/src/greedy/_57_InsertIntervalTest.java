package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _57_InsertIntervalTest {

    _57_InsertInterval target = null;

    @Before
    public void before() throws Exception {
        target = new _57_InsertInterval();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testInsert1() throws Exception {
        int[][] intervals = new int[][]{
                {1, 3}, {6, 9}
        };
        int[] newInterval = {2, 5};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{1, 5}, rst[0]);
        assertArrayEquals(new int[]{6, 9}, rst[1]);
    }

    @Test
    public void testInsert2() throws Exception {
        int[][] intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        int[] newInterval = {4, 8};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(3, rst.length);
        assertArrayEquals(new int[]{1, 2}, rst[0]);
        assertArrayEquals(new int[]{3, 10}, rst[1]);
        assertArrayEquals(new int[]{12, 16}, rst[2]);
    }

    @Test
    public void testInsert3() throws Exception {
        int[][] intervals = new int[][]{
                {2, 3}, {6, 9}
        };
        int[] newInterval = {1, 10};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(1, rst.length);
        assertArrayEquals(new int[]{1, 10}, rst[0]);
    }

    @Test
    public void testInsert4() throws Exception {
        int[][] intervals = new int[][]{
                {2, 3}, {6, 9}
        };
        int[] newInterval = {1, 2};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{1, 3}, rst[0]);
        assertArrayEquals(new int[]{6, 9}, rst[1]);
    }

    @Test
    public void testInsert5() throws Exception {
        int[][] intervals = new int[][]{
                {2, 3}, {6, 9}
        };
        int[] newInterval = {7, 10};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{2, 3}, rst[0]);
        assertArrayEquals(new int[]{6, 10}, rst[1]);
    }

    @Test
    public void testInsert6() throws Exception {
        int[][] intervals = new int[][]{
                {2, 5}, {6, 9}
        };
        int[] newInterval = {0, 7};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(1, rst.length);
        assertArrayEquals(new int[]{0, 9}, rst[0]);
    }

    @Test
    public void testInsert7() throws Exception {
        int[][] intervals = new int[][]{
                {2, 5}, {6, 9}
        };
        int[] newInterval = {4, 10};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(1, rst.length);
        assertArrayEquals(new int[]{2, 10}, rst[0]);
    }

    @Test
    public void testInsert8() throws Exception {
        int[][] intervals = new int[][]{
                {2, 5}, {6, 9}
        };
        int[] newInterval = {4, 7};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(1, rst.length);
        assertArrayEquals(new int[]{2, 9}, rst[0]);
    }

    @Test
    public void testInsert9() throws Exception {
        int[][] intervals = new int[][]{
                {2, 3}, {7, 9}
        };
        int[] newInterval = {4, 6};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(3, rst.length);
        assertArrayEquals(new int[]{2, 3}, rst[0]);
        assertArrayEquals(new int[]{4, 6}, rst[1]);
        assertArrayEquals(new int[]{7, 9}, rst[2]);
    }

    @Test
    public void testInsert10() throws Exception {
        int[][] intervals = new int[][]{
                {2, 6}, {8, 9}
        };
        int[] newInterval = {3, 7};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{2, 7}, rst[0]);
        assertArrayEquals(new int[]{8, 9}, rst[1]);
    }

    @Test
    public void testInsert11() throws Exception {
        int[][] intervals = new int[][]{
                {2, 3}, {5, 9}
        };
        int[] newInterval = {4, 6};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{2, 3}, rst[0]);
        assertArrayEquals(new int[]{4, 9}, rst[1]);
    }

    @Test
    public void testInsert12() throws Exception {
        int[][] intervals = new int[][]{
                {0, 0}, {1, 3}, {5, 11}
        };
        int[] newInterval = {0, 3};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(2, rst.length);
        assertArrayEquals(new int[]{0, 3}, rst[0]);
        assertArrayEquals(new int[]{5, 11}, rst[1]);
    }

    @Test
    public void testInsert13() throws Exception {
        int[][] intervals = new int[][]{
        };
        int[] newInterval = {4, 6};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(1, rst.length);
        assertArrayEquals(new int[]{4, 6}, rst[0]);
    }

    @Test
    public void testInsert14() throws Exception {
        int[][] intervals = new int[][]{
                {0, 3}, {4, 4}, {8, 8}, {18, 21}
        };
        int[] newInterval = {4, 6};
        int[][] rst = target.insert(intervals, newInterval);

        assertEquals(4, rst.length);
        assertArrayEquals(new int[]{0, 3}, rst[0]);
        assertArrayEquals(new int[]{4, 6}, rst[1]);
        assertArrayEquals(new int[]{8, 8}, rst[2]);
        assertArrayEquals(new int[]{18, 21}, rst[3]);
    }
}
