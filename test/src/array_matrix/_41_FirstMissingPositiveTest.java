package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _41_FirstMissingPositiveTest {

    _41_FirstMissingPositive target = null;

    @Before
    public void before() throws Exception {
        target = new _41_FirstMissingPositive();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFirstMissingPositive1() throws Exception {
        int missing = target.firstMissingPositive(new int[]{1, 2, 0});
        assertEquals(3, missing);
    }

    @Test
    public void testFirstMissingPositive2() throws Exception {
        int missing = target.firstMissingPositive(new int[]{3, 4, -1, 1});
        assertEquals(2, missing);
    }

    @Test
    public void testFirstMissingPositive3() throws Exception {
        int missing = target.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        assertEquals(1, missing);
    }

    @Test
    public void testFirstMissingPositive4() throws Exception {
        int missing = target.firstMissingPositive(new int[]{1});
        assertEquals(2, missing);
    }

    @Test
    public void testFirstMissingPositive5() throws Exception {
        int missing = target.firstMissingPositive(new int[]{1, 2, 3, 4, 5});
        assertEquals(6, missing);
    }

    @Test
    public void testFirstMissingPositive6() throws Exception {
        int missing = target.firstMissingPositive(new int[]{1, 1});
        assertEquals(2, missing);
    }
}
