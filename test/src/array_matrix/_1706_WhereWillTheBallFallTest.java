package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1706_WhereWillTheBallFallTest {

    _1706_WhereWillTheBallFall target = null;

    @Before
    public void before() throws Exception {
        target = new _1706_WhereWillTheBallFall();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindBall1() throws Exception {
        int[] output = target.findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        });
        assertArrayEquals(new int[]{1, -1, -1, -1, -1}, output);
    }

    @Test
    public void testFindBall2() throws Exception {
        int[] output = target.findBall(new int[][]{
                {-1},
        });
        assertArrayEquals(new int[]{-1}, output);
    }

    @Test
    public void testFindBall3() throws Exception {
        int[] output = target.findBall(new int[][]{
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, -1}, output);
    }

    @Test
    public void testFindBall4() throws Exception {
        int[] output = target.findBall(new int[][]{
                {1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1},
                {-1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1},
                {1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, -1, 1, -1}
        });
        assertArrayEquals(new int[]{-1, -1, 1, -1, -1, -1, -1, 10, 11, -1, -1, 12, 13, -1, -1, -1, -1, -1, 17, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, output);
    }

}
