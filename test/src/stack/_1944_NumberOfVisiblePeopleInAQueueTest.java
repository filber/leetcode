package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1944_NumberOfVisiblePeopleInAQueueTest {

    _1944_NumberOfVisiblePeopleInAQueue target = null;

    @Before
    public void before() throws Exception {
        target = new _1944_NumberOfVisiblePeopleInAQueue();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCanSeePersonsCount1() throws Exception {
        int[] ans = target.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
        assertArrayEquals(new int[]{3, 1, 2, 1, 1, 0}, ans);
    }

    @Test
    public void testCanSeePersonsCount2() throws Exception {
        int[] ans = target.canSeePersonsCount(new int[]{5, 1, 2, 3, 10});
        assertArrayEquals(new int[]{4, 1, 1, 1, 0}, ans);
    }

    @Test
    public void testCanSeePersonsCount3() throws Exception {
        int[] ans = target.canSeePersonsCount(new int[]{4, 3, 2, 1});
        assertArrayEquals(new int[]{1, 1, 1, 0}, ans);
    }

    @Test
    public void testCanSeePersonsCount4() throws Exception {
        int[] ans = target.canSeePersonsCount(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{1, 1, 1, 0}, ans);
    }

    @Test
    public void testCanSeePersonsCount5() throws Exception {
        int[] ans = target.canSeePersonsCount(new int[]{11, 19, 12, 15, 14, 18, 7, 1, 8, 9});
        assertArrayEquals(new int[]{1, 3, 1, 2, 1, 3, 2, 1, 1, 0}, ans);
    }


}
