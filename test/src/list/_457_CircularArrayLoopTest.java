package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _457_CircularArrayLoopTest {

    _457_CircularArrayLoop target = null;

    @Before
    public void before() throws Exception {
        target = new _457_CircularArrayLoop();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCircularArrayLoop1() throws Exception {
        // 0->2->3->0->2...
        // len = 3
        boolean circular = target.circularArrayLoop(new int[]{2, -1, 1, 2, 2});
        assertTrue(circular);
    }

    @Test
    public void testCircularArrayLoop2() throws Exception {
        // 0->1->1->1...
        // len = 1
        boolean circular = target.circularArrayLoop(new int[]{-1, 2});
        assertFalse(circular);
    }

    @Test
    public void testCircularArrayLoop3() throws Exception {
        // 0->3->1->2->1->2
        // len = 2, not all positive or all negative
        boolean circular = target.circularArrayLoop(new int[]{-2, 1, -1, -2, -2});
        assertFalse(circular);
    }

    @Test
    public void testCircularArrayLoop4() throws Exception {
        // false: 0->1->0->1...
        // true: 2->3->4->2
        boolean circular = target.circularArrayLoop(new int[]{1, -1, 1, 1, 3});
        assertTrue(circular);
    }

    @Test
    public void testCircularArrayLoop5() throws Exception {
        // 0->0->0...
        boolean circular = target.circularArrayLoop(new int[]{-1});
        assertFalse(circular);
    }

    @Test
    public void testCircularArrayLoop6() throws Exception {
        // 0->0->0...
        boolean circular = target.circularArrayLoop(new int[]{1});
        assertFalse(circular);
    }

    @Test
    public void testCircularArrayLoop7() throws Exception {
        // 0->1->0->1...
        boolean circular = target.circularArrayLoop(new int[]{1, 1});
        assertTrue(circular);
    }

    @Test
    public void testCircularArrayLoop8() throws Exception {
        // 0->1->1->1...
        boolean circular = target.circularArrayLoop(new int[]{-2, -3, -9});
        assertFalse(circular);
    }
} 
