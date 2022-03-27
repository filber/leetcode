package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1337_TheKWeakestRowsInAMatrixTest {

    _1337_TheKWeakestRowsInAMatrix target = null;

    @Before
    public void before() throws Exception {
        target = new _1337_TheKWeakestRowsInAMatrix();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testKWeakestRows1() throws Exception {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int[] rows = target.kWeakestRows(mat, 3);
        assertArrayEquals(new int[]{2, 0, 3}, rows);
    }

    @Test
    public void testKWeakestRows2() throws Exception {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};
        int[] rows = target.kWeakestRows(mat, 2);
        assertArrayEquals(new int[]{0, 2}, rows);
    }
}
