package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_BitonicArrayMaximumTest {

    _EX_BitonicArrayMaximum target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_BitonicArrayMaximum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMaximum1() throws Exception {
        int max = target.findMaximum(new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1});
        assertEquals(500, max);
    }

    @Test
    public void testFindMaximum2() throws Exception {
        int max = target.findMaximum(new int[]{1, 3, 50, 10, 9, 7, 6});
        assertEquals(50, max);
    }

    @Test
    public void testFindMaximum3() throws Exception {
        int max = target.findMaximum(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertEquals(7, max);
    }

    @Test
    public void testFindMaximum4() throws Exception {
        int max = target.findMaximum(new int[]{7, 6, 5, 4, 3, 2, 1});
        assertEquals(7, max);
    }

    @Test
    public void testFindMaximum5() throws Exception {
        int max = target.findMaximum(new int[]{2});
        assertEquals(2, max);
    }

    @Test
    public void testFindMaximum6() throws Exception {
        int max = target.findMaximum(new int[]{1, 2});
        assertEquals(2, max);
    }

    @Test
    public void testFindMaximum7() throws Exception {
        int max = target.findMaximum(new int[]{2, 1});
        assertEquals(2, max);
    }
}
