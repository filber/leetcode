package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _542_01MatrixTest {

    _542_01Matrix target;

    @Before
    public void before() throws Exception {
        target = new _542_01Matrix();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testUpdateMatrix1() throws Exception {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] actual = target.updateMatrix(mat);
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testUpdateMatrix2() throws Exception {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        int[][] actual = target.updateMatrix(mat);
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}
