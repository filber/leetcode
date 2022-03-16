package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2122_RecoverTheOriginalArrayTest {

    _2122_RecoverTheOriginalArray target = null;

    @Before
    public void before() throws Exception {
        target = new _2122_RecoverTheOriginalArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRecoverArray1() throws Exception {
        int[] arr = target.recoverArray(new int[]{2, 10, 6, 4, 8, 12});
        assertArrayEquals(new int[]{3, 7, 11}, arr);
    }

    @Test
    public void testRecoverArray2() throws Exception {
        int[] arr = target.recoverArray(new int[]{1, 1, 3, 3});
        assertArrayEquals(new int[]{2, 2}, arr);
    }

    @Test
    public void testRecoverArray3() throws Exception {
        int[] arr = target.recoverArray(new int[]{5, 435});
        assertArrayEquals(new int[]{220}, arr);
    }
}
