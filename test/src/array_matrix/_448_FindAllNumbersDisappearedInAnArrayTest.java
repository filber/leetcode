package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _448_FindAllNumbersDisappearedInAnArrayTest {

    _448_FindAllNumbersDisappearedInAnArray target = null;

    @Before
    public void before() throws Exception {
        target = new _448_FindAllNumbersDisappearedInAnArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindDisappearedNumbers1() throws Exception {
        List<Integer> list = target.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        assertArrayEquals(new Integer[]{5, 6}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindDisappearedNumbers2() throws Exception {
        List<Integer> list = target.findDisappearedNumbers(new int[]{1, 1});
        assertArrayEquals(new Integer[]{2}, list.toArray(new Integer[0]));
    }

    @Test
    public void testFindDisappearedNumbers3() throws Exception {
        List<Integer> list = target.findDisappearedNumbers(new int[]{1, 2, 3, 4});
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindDisappearedNumbers4() throws Exception {
        List<Integer> list = target.findDisappearedNumbers(new int[]{3, 4, 2, 1});
        assertTrue(list.isEmpty());
    }
}
