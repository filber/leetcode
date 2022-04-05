package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _645_SetMismatchTest {

    _645_SetMismatch target = null;

    @Before
    public void before() throws Exception {
        target = new _645_SetMismatch();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindErrorNums1() throws Exception {
        int[] ans = target.findErrorNums(new int[]{4, 2, 1, 2});
        assertArrayEquals(new int[]{2, 3}, ans);
    }

    @Test
    public void testFindErrorNums2() throws Exception {
        int[] ans = target.findErrorNums(new int[]{1, 2, 2, 4});
        assertArrayEquals(new int[]{2, 3}, ans);
    }

    @Test
    public void testFindErrorNums3() throws Exception {
        int[] ans = target.findErrorNums(new int[]{1, 1});
        assertArrayEquals(new int[]{1, 2}, ans);
    }
} 
