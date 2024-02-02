package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _221_MaximalSquareTest {

    _221_MaximalSquare target;

    @Before
    public void setUp() throws Exception {
        target = new _221_MaximalSquare();
    }

    @Test
    public void testMaximalSquare1() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int maxArea = target.maximalSquare(matrix);
        assertEquals(4, maxArea);
    }

    @Test
    public void testMaximalSquare2() {
        char[][] matrix = new char[][]{
                {'0', '1'},
                {'1', '0'}};
        int maxArea = target.maximalSquare(matrix);
        assertEquals(1, maxArea);
    }
}