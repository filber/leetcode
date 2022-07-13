package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class _260_SingleNumberIIITest {

    _260_SingleNumberIII target = null;

    @Before
    public void before() throws Exception {
        target = new _260_SingleNumberIII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSingleNumber1() throws Exception {
        int[] res = target.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        Set<Integer> set = new HashSet<>();
        for (int num : res) {
            set.add(num);
        }
        assertEquals(2, res.length);
        assertTrue(set.contains(3));
        assertTrue(set.contains(5));
    }

    @Test
    public void testSingleNumber2() throws Exception {
        int[] res = target.singleNumber(new int[]{-1, 0});
        assertArrayEquals(new int[]{0, -1}, res);
    }

    @Test
    public void testSingleNumber3() throws Exception {
        int[] res = target.singleNumber(new int[]{0, 1});
        assertArrayEquals(new int[]{0, 1}, res);
    }

    @Test
    public void testSingleNumber4() throws Exception {
        int[] res = target.singleNumber(new int[]{0, 0, 2, 1});
        assertArrayEquals(new int[]{2, 1}, res);
    }

    @Test
    public void testSingleNumber5() throws Exception {
        int[] res = target.singleNumber(new int[]{0, 2, 2, 1});
        assertArrayEquals(new int[]{0, 1}, res);
    }

    @Test
    public void testSingleNumber6() throws Exception {
        int[] res = target.singleNumber(new int[]{2, 1, 2, 3, 4, 1});
        assertArrayEquals(new int[]{4, 3}, res);
    }

    @Test
    public void testSingleNumber7() throws Exception {
        int[] res = target.singleNumber(new int[]{1, 2});
        assertArrayEquals(new int[]{2, 1}, res);
    }

    @Test
    public void testSingleNumber8() throws Exception {
        int[] res = target.singleNumber(new int[]{-1, 0});
        assertArrayEquals(new int[]{-1, 0}, res);
    }

    @Test
    public void testSingleNumber9() throws Exception {
        int[] res = target.singleNumber(new int[]{1, 3, 1, 3, 2, 5});
        Set<Integer> set = new HashSet<>();
        for (int num : res) {
            set.add(num);
        }
        assertEquals(2, res.length);
        assertTrue(set.contains(2));
        assertTrue(set.contains(5));
    }
}
