package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_FindAnElementInBitonicArrayTest {

    _EX_FindAnElementInBitonicArray target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_FindAnElementInBitonicArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindInArray1() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 20);
        assertEquals(3, idx);
    }

    @Test
    public void testFindInArray2() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, -3);
        assertEquals(0, idx);
    }

    @Test
    public void testFindInArray3() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 1);
        assertEquals(6, idx);
    }

    @Test
    public void testFindInArray4() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 20);
        assertEquals(3, idx);
    }

    @Test
    public void testFindInArray5() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, -5);
        assertEquals(-1, idx);
    }

    @Test
    public void testFindInArray6() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 25);
        assertEquals(-1, idx);
    }

    @Test
    public void testFindInArray7() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 7);
        assertEquals(-1, idx);
    }

    @Test
    public void testFindInArray8() throws Exception {
        int idx = target.findInArray(new int[]{-3, 9, 18, 20, 17, 5, 1}, 4);
        assertEquals(-1, idx);
    }

    @Test
    public void testFindInArray9() throws Exception {
        int idx = target.findInArray(new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1}, 30);
        assertEquals(-1, idx);
    }
}
