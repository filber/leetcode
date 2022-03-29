package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _81_SearchInRotatedSortedArrayIITest {

    _81_SearchInRotatedSortedArrayII target = null;

    @Before
    public void before() throws Exception {
        target = new _81_SearchInRotatedSortedArrayII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearch1() throws Exception {
        boolean ans = target.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
        assertTrue(ans);
    }

    @Test
    public void testSearch2() throws Exception {
        boolean ans = target.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);
        assertFalse(ans);
    }

    @Test
    public void testSearch3() throws Exception {
        boolean ans = target.search(new int[]{1, 1, 1, 1, 0, 1, 1}, 0);
        assertTrue(ans);
    }
}
