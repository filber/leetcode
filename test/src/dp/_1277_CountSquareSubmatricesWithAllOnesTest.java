package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1277_CountSquareSubmatricesWithAllOnesTest {

    _1277_CountSquareSubmatricesWithAllOnes target;

    @Before
    public void setUp() throws Exception {
        target = new _1277_CountSquareSubmatricesWithAllOnes();
    }

    @Test
    public void testCountSquares1() {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int count = target.countSquares(matrix);
        // 15 [side1:10, side2:4, side3:1]
        assertEquals(15, count);
    }

    @Test
    public void testCountSquares2() {
        int[][] matrix = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        int count = target.countSquares(matrix);
        // 7 [side1:6, side2:1]
        assertEquals(7, count);
    }
}