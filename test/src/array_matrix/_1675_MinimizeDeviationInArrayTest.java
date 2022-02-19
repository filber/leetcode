package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1675_MinimizeDeviationInArrayTest {

    _1675_MinimizeDeviationInArray target = null;

    @Before
    public void before() throws Exception {
        target = new _1675_MinimizeDeviationInArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinimumDeviation1() throws Exception {
        // 1 - [2,2,3,2]
        int deviation = target.minimumDeviation(new int[]{1, 2, 3, 4});
        assertEquals(1, deviation);
    }

    @Test
    public void testMinimumDeviation2() throws Exception {
        // 3 - [4,2,5,5,3]
        int deviation = target.minimumDeviation(new int[]{4, 1, 5, 20, 3});
        assertEquals(3, deviation);
    }

    @Test
    public void testMinimumDeviation3() throws Exception {
        // 3 - [2,5,4]
        int deviation = target.minimumDeviation(new int[]{2, 10, 8});
        assertEquals(3, deviation);
    }
}
