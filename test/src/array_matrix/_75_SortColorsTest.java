package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _75_SortColorsTest {

    _75_SortColors target = null;

    @Before
    public void before() throws Exception {
        target = new _75_SortColors();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSortColors1() throws Exception {
        int[] colors = new int[]{2, 0, 2, 1, 1, 0};
        target.sortColors(colors);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, colors);
    }

    @Test
    public void testSortColors2() throws Exception {
        int[] colors = new int[]{2, 0, 1};
        target.sortColors(colors);
        assertArrayEquals(new int[]{0, 1, 2}, colors);
    }
}
