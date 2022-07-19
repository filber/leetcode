package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _118_PascalsTriangleTest {

    _118_PascalsTriangle target;

    @Before
    public void before() throws Exception {
        target = new _118_PascalsTriangle();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGenerate1() throws Exception {
        List<List<Integer>> list = target.generate(1);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{1}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testGenerate2() throws Exception {
        List<List<Integer>> list = target.generate(5);
        assertEquals(5, list.size());
        assertArrayEquals(new Integer[]{1}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 1}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 2, 1}, list.get(2).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 3, 3, 1}, list.get(3).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 4, 6, 4, 1}, list.get(4).toArray(new Integer[0]));
    }
} 
