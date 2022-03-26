package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _704_BinarySearchTest {

    _704_BinarySearch target = null;

    @Before
    public void before() throws Exception {
        target = new _704_BinarySearch();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearch1() throws Exception {
        int idx = target.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assertEquals(4, idx);
    }

    @Test
    public void testSearch2() throws Exception {
        int idx = target.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        assertEquals(-1, idx);
    }

    @Test
    public void testSearch3() throws Exception {
        int idx = target.search(new int[]{-1, 0, 3, 5, 9, 12}, -2);
        assertEquals(-1, idx);
    }

    @Test
    public void testSearch4() throws Exception {
        int idx = target.search(new int[]{-1, 0, 3, 5, 9, 12}, 13);
        assertEquals(-1, idx);
    }
}
