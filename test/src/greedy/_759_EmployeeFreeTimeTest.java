package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _759_EmployeeFreeTimeTest {

    _759_EmployeeFreeTime target = null;

    @Before
    public void before() throws Exception {
        target = new _759_EmployeeFreeTime();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testEmployeeFreeTime1() throws Exception {
        int[][][] schedule = {
                {{1, 2}, {5, 6}},
                {{1, 3}, {4, 10}},
        };
        int[][] free = target.employeeFreeTime(schedule);
        assertEquals(1, free.length);
        assertArrayEquals(new int[]{3, 4}, free[0]);
    }

    @Test
    public void testEmployeeFreeTime2() throws Exception {
        int[][][] schedule = {
                {{1, 3}, {6, 7}},
                {{2, 4}},
                {{2, 5}, {9, 12}},
        };
        int[][] free = target.employeeFreeTime(schedule);
        assertEquals(2, free.length);
        assertArrayEquals(new int[]{5, 6}, free[0]);
        assertArrayEquals(new int[]{7, 9}, free[1]);
    }

    @Test
    public void testEmployeeFreeTime3() throws Exception {
        int[][][] schedule = {
                {{1, 2}, {5, 6}},
        };
        int[][] free = target.employeeFreeTime(schedule);
        assertEquals(1, free.length);
        assertArrayEquals(new int[]{2, 5}, free[0]);
    }

    @Test
    public void testEmployeeFreeTime4() throws Exception {
        int[][][] schedule = {
                {{1, 2}},
        };
        int[][] free = target.employeeFreeTime(schedule);
        assertEquals(0, free.length);
    }
}
