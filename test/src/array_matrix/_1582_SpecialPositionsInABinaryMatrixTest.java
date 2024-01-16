package array_matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1582_SpecialPositionsInABinaryMatrixTest {

    _1582_SpecialPositionsInABinaryMatrix target;

    @Before
    public void setUp() {
        target = new _1582_SpecialPositionsInABinaryMatrix();
    }

    @Test
    public void testNumSpecial1() {
        int[][] matrix = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        int cnt = target.numSpecial(matrix);
        assertEquals(1, cnt);
    }

    @Test
    public void testNumSpecial2() {
        int[][] matrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int cnt = target.numSpecial(matrix);
        assertEquals(3, cnt);
    }
}