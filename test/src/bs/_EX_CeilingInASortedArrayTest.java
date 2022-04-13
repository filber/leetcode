package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_CeilingInASortedArrayTest {

    _EX_CeilingInASortedArray target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_CeilingInASortedArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCeilSearch1() throws Exception {
        int ceil = target.ceilSearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 0);
        assertEquals(1, ceil);
    }

    @Test
    public void testCeilSearch2() throws Exception {
        int ceil = target.ceilSearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 1);
        assertEquals(1, ceil);
    }

    @Test
    public void testCeilSearch3() throws Exception {
        int ceil = target.ceilSearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 5);
        assertEquals(8, ceil);
    }

    @Test
    public void testCeilSearch4() throws Exception {
        int ceil = target.ceilSearch(new int[]{1, 2, 8, 10, 10, 12, 19}, 20);
        assertEquals(-1, ceil);
    }
}
