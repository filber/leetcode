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
        List<Integer> list = target.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, list.toArray(new Integer[0]));
    }
}
