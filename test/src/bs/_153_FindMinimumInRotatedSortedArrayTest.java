package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _153_FindMinimumInRotatedSortedArrayTest {

    _153_FindMinimumInRotatedSortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _153_FindMinimumInRotatedSortedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMin1() throws Exception {
        int min = target.findMin(new int[]{3, 4, 5, 1, 2});
        assertEquals(1, min);
    }

    @Test
    public void testFindMin2() throws Exception {
        int min = target.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        assertEquals(0, min);
    }

    @Test
    public void testFindMin3() throws Exception {
        int min = target.findMin(new int[]{1, 2});
        assertEquals(1, min);
    }

    @Test
    public void testFindMin4() throws Exception {
        int min = target.findMin(new int[]{11, 13, 15, 17});
        assertEquals(11, min);
    }

    @Test
    public void testFindMin5() throws Exception {
        int min = target.findMin(new int[]{1});
        assertEquals(1, min);
    }

    @Test
    public void testFindMin6() throws Exception {
        int min = target.findMin(new int[]{2, 1});
        assertEquals(1, min);
    }
}
