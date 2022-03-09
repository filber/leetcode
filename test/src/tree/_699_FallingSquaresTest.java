package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _699_FallingSquaresTest {

    _699_FallingSquares target = null;

    @Before
    public void before() throws Exception {
        target = new _699_FallingSquares();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFallingSquares1() throws Exception {
        List<Integer> list = target.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}});
        assertArrayEquals(new Integer[]{2, 5, 5}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFallingSquares2() throws Exception {
        List<Integer> list = target.fallingSquares(new int[][]{{100, 100}, {200, 100}});
        assertArrayEquals(new Integer[]{100, 100}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFallingSquares3() throws Exception {
        List<Integer> list = target.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}, {5, 4}});
        assertArrayEquals(new Integer[]{2, 5, 5, 5}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFallingSquares4() throws Exception {
        List<Integer> list = target.fallingSquares(new int[][]{{4, 6}, {4, 2}, {4, 3}});
        assertArrayEquals(new Integer[]{6, 8, 11}, list.toArray(new Integer[0]));
    }
}