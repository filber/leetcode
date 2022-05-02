package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _905_SortArrayByParityTest {

    _905_SortArrayByParity target = null;

    @Before
    public void before() throws Exception {
        target = new _905_SortArrayByParity();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSortArrayByParity1() throws Exception {
        int[] arr = target.sortArrayByParity(new int[]{3, 1, 2, 4});
        assertArrayEquals(new int[]{4, 2, 1, 3}, arr);
    }

    @Test
    public void testSortArrayByParity2() throws Exception {
        int[] arr = target.sortArrayByParity(new int[]{0});
        assertArrayEquals(new int[]{0}, arr);
    }

    @Test
    public void testSortArrayByParity3() throws Exception {
        int[] arr = target.sortArrayByParity(new int[]{1, 0});
        assertArrayEquals(new int[]{0, 1}, arr);
    }

    @Test
    public void testSortArrayByParity4() throws Exception {
        int[] arr = target.sortArrayByParity(new int[]{1, 3, 0});
        assertArrayEquals(new int[]{0, 3, 1}, arr);
    }

    @Test
    public void testSortArrayByParity5() throws Exception {
        int[] arr = target.sortArrayByParity(new int[]{2, 0});
        assertArrayEquals(new int[]{2, 0}, arr);
    }

} 
