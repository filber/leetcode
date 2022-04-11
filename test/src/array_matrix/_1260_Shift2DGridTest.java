package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _1260_Shift2DGridTest {

    _1260_Shift2DGrid target = null;

    @Before
    public void before() throws Exception {
        target = new _1260_Shift2DGrid();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testShiftGrid1() throws Exception {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List list = target.shiftGrid(grid, k);
        assertArrayEquals(new int[]{9, 1, 2}, (int[]) list.get(0));
        assertArrayEquals(new int[]{3, 4, 5}, (int[]) list.get(1));
        assertArrayEquals(new int[]{6, 7, 8}, (int[]) list.get(2));
    }

    @Test
    public void testShiftGrid2() throws Exception {
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 4;
        List list = target.shiftGrid(grid, k);
        assertArrayEquals(new int[]{12, 0, 21, 13}, (int[]) list.get(0));
        assertArrayEquals(new int[]{3, 8, 1, 9}, (int[]) list.get(1));
        assertArrayEquals(new int[]{19, 7, 2, 5}, (int[]) list.get(2));
        assertArrayEquals(new int[]{4, 6, 11, 10}, (int[]) list.get(3));
    }
}
