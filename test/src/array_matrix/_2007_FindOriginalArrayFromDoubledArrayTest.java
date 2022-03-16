package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2007_FindOriginalArrayFromDoubledArrayTest {

    _2007_FindOriginalArrayFromDoubledArray target = null;

    @Before
    public void before() throws Exception {
        target = new _2007_FindOriginalArrayFromDoubledArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindOriginalArray1() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
        assertArrayEquals(new int[]{1, 3, 4}, arr);
    }

    @Test
    public void testFindOriginalArray2() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{6, 3, 0, 1});
        assertEquals(0, arr.length);
    }

    @Test
    public void testFindOriginalArray3() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{1});
        assertEquals(0, arr.length);
    }

    @Test
    public void testFindOriginalArray4() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{0, 0});
        assertArrayEquals(new int[]{0}, arr);
    }

    @Test
    public void testFindOriginalArray7() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{0, 1});
        assertEquals(0, arr.length);
    }

    @Test
    public void testFindOriginalArray5() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{0, 0, 2, 4});
        assertArrayEquals(new int[]{0, 2}, arr);
    }

    @Test
    public void testFindOriginalArray6() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{0, 0, 2, 5});
        assertEquals(0, arr.length);
    }

    @Test
    public void testFindOriginalArray8() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{2, 1, 2, 4, 2, 4});
        assertArrayEquals(new int[]{1, 2, 2}, arr);
    }

    @Test
    public void testFindOriginalArray9() throws Exception {
        int[] arr = target.findOriginalArray(new int[]{0, 0, 0, 0});
        assertArrayEquals(new int[]{0, 0}, arr);
    }
}