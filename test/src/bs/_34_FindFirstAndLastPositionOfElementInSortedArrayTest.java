package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _34_FindFirstAndLastPositionOfElementInSortedArrayTest {

    _34_FindFirstAndLastPositionOfElementInSortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _34_FindFirstAndLastPositionOfElementInSortedArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSearchRange1() throws Exception {
        int[] range = target.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        assertArrayEquals(new int[]{3, 4}, range);
    }

    @Test
    public void testSearchRange2() throws Exception {
        int[] range = target.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        assertArrayEquals(new int[]{-1, -1}, range);
    }

    @Test
    public void testSearchRange3() throws Exception {
        int[] range = target.searchRange(new int[]{}, 0);
        assertArrayEquals(new int[]{-1, -1}, range);
    }

    @Test
    public void testSearchRange4() throws Exception {
        int[] range = target.searchRange(new int[]{5, 7, 7, 7, 7, 8, 8, 10}, 7);
        assertArrayEquals(new int[]{1, 4}, range);
    }
}