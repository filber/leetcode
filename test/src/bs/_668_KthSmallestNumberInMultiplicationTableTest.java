package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _668_KthSmallestNumberInMultiplicationTableTest {

    _668_KthSmallestNumberInMultiplicationTable target = null;

    @Before
    public void before() throws Exception {
        target = new _668_KthSmallestNumberInMultiplicationTable();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindKthNumber1() throws Exception {
        //1,2,3
        //2,4,6
        //3,6,9
        //[1,2,2,3,3,4,6,6,9]
        assertEquals(1, target.findKthNumber(3, 3, 1));
        assertEquals(2, target.findKthNumber(3, 3, 2));
        assertEquals(2, target.findKthNumber(3, 3, 3));
        assertEquals(3, target.findKthNumber(3, 3, 4));
        assertEquals(3, target.findKthNumber(3, 3, 5));
        assertEquals(4, target.findKthNumber(3, 3, 6));
        assertEquals(6, target.findKthNumber(3, 3, 7));
        assertEquals(6, target.findKthNumber(3, 3, 8));
        assertEquals(9, target.findKthNumber(3, 3, 9));
    }

    @Test
    public void testFindKthNumber2() throws Exception {
        //1,2,3
        //2,4,6
        //[1,2,2,3,4,6]
        assertEquals(1, target.findKthNumber(2, 3, 1));
        assertEquals(2, target.findKthNumber(2, 3, 2));
        assertEquals(2, target.findKthNumber(2, 3, 3));
        assertEquals(3, target.findKthNumber(2, 3, 4));
        assertEquals(4, target.findKthNumber(2, 3, 5));
        assertEquals(6, target.findKthNumber(2, 3, 6));
    }

    @Test
    public void testFindKthNumber3() throws Exception {
        // 1
        //[1]
        assertEquals(1, target.findKthNumber(1, 1, 1));
    }

    @Test
    public void testFindKthNumber4() throws Exception {
        // 1,2,3,4
        //[1,2,3,4]
        assertEquals(1, target.findKthNumber(1, 4, 1));
        assertEquals(2, target.findKthNumber(1, 4, 2));
        assertEquals(3, target.findKthNumber(1, 4, 3));
        assertEquals(4, target.findKthNumber(1, 4, 4));
    }

    @Test
    public void testFindKthNumber5() throws Exception {
        // 1
        // 2
        // 3
        // 4
        //[1,2,3,4]
        assertEquals(1, target.findKthNumber(4, 1, 1));
        assertEquals(2, target.findKthNumber(4, 1, 2));
        assertEquals(3, target.findKthNumber(4, 1, 3));
        assertEquals(4, target.findKthNumber(4, 1, 4));
    }
}
