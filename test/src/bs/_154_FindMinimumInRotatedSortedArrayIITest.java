package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _154_FindMinimumInRotatedSortedArrayIITest {

    _154_FindMinimumInRotatedSortedArrayII target = null;

    @Before
    public void before() throws Exception {
        target = new _154_FindMinimumInRotatedSortedArrayII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMin1() throws Exception {
        int min = target.findMin(new int[]{4, 5, 6, 7, 0, 1, 4});
        assertEquals(0, min);
    }

    @Test
    public void testFindMin2() throws Exception {
        int min = target.findMin(new int[]{4, 4, 5, 5, 5, 6, 6, 7, 7, 7, -1, 0, 1, 4});
        assertEquals(-1, min);
    }

    @Test
    public void testFindMin3() throws Exception {
        int min = target.findMin(new int[]{4, 4, 5, 5, 5, 6, 6, 7, 7, 7, -1, -1, -1, 0, 1, 4});
        assertEquals(-1, min);
    }

    @Test
    public void testFindMin4() throws Exception {
        int min = target.findMin(new int[]{1, 3, 5});
        assertEquals(1, min);
    }

    @Test
    public void testFindMin5() throws Exception {
        int min = target.findMin(new int[]{2, 2, 2, 0, 1});
        assertEquals(0, min);
    }
}
