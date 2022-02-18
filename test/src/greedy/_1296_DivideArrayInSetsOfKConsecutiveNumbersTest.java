package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1296_DivideArrayInSetsOfKConsecutiveNumbersTest {

    _1296_DivideArrayInSetsOfKConsecutiveNumbers target = null;

    @Before
    public void before() throws Exception {
        target = new _1296_DivideArrayInSetsOfKConsecutiveNumbers();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsPossibleDivide1() throws Exception {
        // [1,2,3,4],[3,4,5,6]
        boolean b = target.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4);
        assertTrue(b);
    }

    @Test
    public void testIsPossibleDivide2() throws Exception {
        // [1,2,3,], [2,3,4], [3,4,5], [9,10,11]
        boolean b = target.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3);
        assertTrue(b);
    }

    @Test
    public void testIsPossibleDivide3() throws Exception {
        boolean b = target.isPossibleDivide(new int[]{1, 2, 3, 4}, 3);
        assertFalse(b);
    }

    @Test
    public void testIsPossibleDivide4() throws Exception {
        boolean b = target.isPossibleDivide(new int[]{16, 21, 26, 35}, 4);
        assertFalse(b);
    }

    @Test
    public void testIsPossibleDivide5() throws Exception {
        boolean b = target.isPossibleDivide(new int[]{9, 10, 11, 5, 6, 7, 5, 6, 7, 7, 8, 9}, 3);
        assertTrue(b);
    }
}
