package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _798_SmallestRotationWithHighestScoreTest {

    _798_SmallestRotationWithHighestScore target = null;

    @Before
    public void before() throws Exception {
        target = new _798_SmallestRotationWithHighestScore();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBestRotation1() throws Exception {
        int k = target.bestRotation(new int[]{2, 4, 1, 3, 0});
        assertEquals(0, k);
    }

    @Test
    public void testBestRotation2() throws Exception {
        int k = target.bestRotation(new int[]{2, 3, 1, 4, 0});
        assertEquals(3, k);
    }

    @Test
    public void testBestRotation3() throws Exception {
        int k = target.bestRotation(new int[]{1, 3, 0, 2, 4});
        assertEquals(0, k);
    }
}
