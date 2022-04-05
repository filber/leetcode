package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _442_FindAllDuplicatesInAnArrayTest {

    _442_FindAllDuplicatesInAnArray target = null;

    @Before
    public void before() throws Exception {
        target = new _442_FindAllDuplicatesInAnArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindDuplicates1() throws Exception {
        List<Integer> list = target.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        assertArrayEquals(new Integer[]{3, 2}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindDuplicates2() throws Exception {
        List<Integer> list = target.findDuplicates(new int[]{1, 1, 2});
        assertArrayEquals(new Integer[]{1}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindDuplicates3() throws Exception {
        List<Integer> list = target.findDuplicates(new int[]{1});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindDuplicates4() throws Exception {
        List<Integer> list = target.findDuplicates(new int[]{1, 2, 3});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindDuplicates5() throws Exception {
        List<Integer> list = target.findDuplicates(new int[]{3, 1, 2});
        assertTrue(list.isEmpty());
    }
}
