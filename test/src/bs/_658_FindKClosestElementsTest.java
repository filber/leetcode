package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _658_FindKClosestElementsTest {

    _658_FindKClosestElements target = null;

    @Before
    public void before() throws Exception {
        target = new _658_FindKClosestElements();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindClosestElements1() throws Exception {
        List<Integer> list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements2() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements3() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 1, -1);
        assertArrayEquals(new Integer[]{1}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements4() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 1, 7);
        assertArrayEquals(new Integer[]{5}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements5() throws Exception {
        List<Integer> list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 2, 3);
        assertArrayEquals(new Integer[]{2, 3}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements6() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 3);
        assertArrayEquals(new Integer[]{2, 3, 4}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements7() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 5, 6}, 2, 3);
        assertArrayEquals(new Integer[]{1, 2}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindClosestElements8() throws Exception {
        List list = target.findClosestElements(new int[]{1, 2, 5, 6}, 3, 3);
        assertArrayEquals(new Integer[]{1, 2, 5}, list.toArray(new Integer[0]));
    }
}
