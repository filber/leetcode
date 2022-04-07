package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_FindFirstKNaturalNumbersMissingInGivenArrayTest {

    _EX_FindFirstKNaturalNumbersMissingInGivenArray target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_FindFirstKNaturalNumbersMissingInGivenArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindKMissing1() throws Exception {
        int[] missing = target.findKMissing(new int[]{2, 3, 4}, 3);
        assertArrayEquals(new int[]{1, 5, 6}, missing);
    }

    @Test
    public void testFindKMissing2() throws Exception {
        int[] missing = target.findKMissing(new int[]{-2, -3, 4}, 2);
        assertArrayEquals(new int[]{1, 2}, missing);
    }

    @Test
    public void testFindKMissing3() throws Exception {
        int[] missing = target.findKMissing(new int[]{1, 2, 3, 4, 5}, 2);
        assertArrayEquals(new int[]{6, 7}, missing);
    }

    @Test
    public void testFindKMissing4() throws Exception {
        int[] missing = target.findKMissing(new int[]{1, 1}, 2);
        assertArrayEquals(new int[]{2, 3}, missing);
    }

    @Test
    public void testFindKMissing5() throws Exception {
        int[] missing = target.findKMissing(new int[]{4, 5, 6}, 4);
        assertArrayEquals(new int[]{1, 2, 3, 7}, missing);
    }

    @Test
    public void testFindKMissing6() throws Exception {
        int[] missing = target.findKMissing(new int[]{-2, -3, 2, 4, 6}, 4);
        assertArrayEquals(new int[]{1, 3, 5, 7}, missing);
    }
} 
