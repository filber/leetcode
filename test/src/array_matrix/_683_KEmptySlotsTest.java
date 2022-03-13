package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _683_KEmptySlotsTest {

    _683_KEmptySlots target = null;

    @Before
    public void before() throws Exception {
        target = new _683_KEmptySlots();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testKEmptySlots1() throws Exception {
        int ans = target.kEmptySlots(new int[]{1, 3, 2}, 1);
        // [1,0,0] 1st day
        // [1,0,1] 2nd day; k = 1
        // [1,1,1] 3rd day
        assertEquals(2, ans);
    }

    @Test
    public void testKEmptySlots2() throws Exception {
        int ans = target.kEmptySlots(new int[]{1, 5, 2, 4, 3}, 2);
        // [1,0,0,0,0] 1st day
        // [1,0,0,0,1] 2nd day
        // [1,1,0,0,1] 3rd day; k = 2
        // [1,1,0,1,1] 4th day
        // [1,1,1,1,1] 5th day
        assertEquals(3, ans);
    }

    @Test
    public void testKEmptySlots3() throws Exception {
        int ans = target.kEmptySlots(new int[]{1, 5, 2, 4, 3}, 1);
        // [1,0,0,0,0] 1st day
        // [1,0,0,0,1] 2nd day
        // [1,1,0,0,1] 3rd day
        // [1,1,0,1,1] 4th day; k = 1
        // [1,1,1,1,1] 5th day
        assertEquals(4, ans);
    }


    @Test
    public void testKEmptySlots4() throws Exception {
        int ans = target.kEmptySlots(new int[]{1, 5, 2, 4, 3}, 0);
        // [1,0,0,0,0] 1st day
        // [1,0,0,0,1] 2nd day
        // [1,1,0,0,1] 3rd day; k = 0
        // [1,1,0,1,1] 4th day
        // [1,1,1,1,1] 5th day
        assertEquals(3, ans);
    }

    @Test
    public void testKEmptySlots5() throws Exception {
        int ans = target.kEmptySlots(new int[]{1}, 2);
        // [1] 1st day
        assertEquals(-1, ans);
    }
}
