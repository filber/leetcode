package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1007_MinimumDominoRotationsForEqualRowTest {

    _1007_MinimumDominoRotationsForEqualRow target = null;

    @Before
    public void before() throws Exception {
        target = new _1007_MinimumDominoRotationsForEqualRow();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinDominoRotations1() throws Exception {
        int rotations = target.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
        assertEquals(2, rotations);
    }

    @Test
    public void testMinDominoRotations2() throws Exception {
        int rotations = target.minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4});
        assertEquals(-1, rotations);
    }

    @Test
    public void testMinDominoRotations3() throws Exception {
        int rotations = target.minDominoRotations(
                new int[]{1, 2, 1, 2, 1},
                new int[]{2, 1, 2, 1, 2});
        assertEquals(2, rotations);
    }

    @Test
    public void testMinDominoRotations4() throws Exception {
        int rotations = target.minDominoRotations(
                new int[]{1, 1, 1, 1, 1},
                new int[]{2, 2, 2, 2, 2});
        assertEquals(0, rotations);
    }
}
