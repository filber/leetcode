package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_YShapeTest {

    _EX_YShape target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_YShape();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSmallestChanges1() throws Exception {
        int[][] matrix = {
                {1, 0, 2},
                {1, 2, 0},
                {0, 2, 0}
        };
        int[][] expected = {
                {2, 0, 2},
                {0, 2, 0},
                {0, 2, 0}
        };

        int[][] changed = target.yShape(matrix);
        for (int i = 0; i < changed.length; i++) {
            assertArrayEquals(expected[i], changed[i]);
        }
    }

    @Test
    public void testSmallestChanges2() throws Exception {
        int[][] matrix = {
                {2, 0, 0, 0, 2},
                {1, 2, 1, 2, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 2, 1, 1},
                {1, 1, 2, 1, 1}
        };

        int[][] expected = {
                {2, 1, 1, 1, 2},
                {1, 2, 1, 2, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 2, 1, 1}
        };

        int[][] changed = target.yShape(matrix);
        for (int i = 0; i < changed.length; i++) {
            assertArrayEquals(expected[i], changed[i]);
        }
    }
}
