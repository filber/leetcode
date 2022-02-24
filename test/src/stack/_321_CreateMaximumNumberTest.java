package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _321_CreateMaximumNumberTest {

    _321_CreateMaximumNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _321_CreateMaximumNumber();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxNumber1() throws Exception {
        int[] res = target.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        assertArrayEquals(new int[]{9, 8, 6, 5, 3}, res);
    }

    @Test
    public void testMaxNumber2() throws Exception {
        int[] res = target.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        assertArrayEquals(new int[]{6, 7, 6, 0, 4}, res);
    }

    @Test
    public void testMaxNumber3() throws Exception {
        int[] res = target.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3);
        assertArrayEquals(new int[]{9, 8, 9}, res);
    }
}
