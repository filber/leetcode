package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import tree._731_MyCalendarII.*;

import static org.junit.Assert.*;

public class _731_MyCalendarIITest {

    MyCalendarTwo target = null;

    @Before
    public void before() throws Exception {
        target = new TMCalendar();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBook1() throws Exception {
        assertTrue(target.book(10, 20));
        assertTrue(target.book(50, 60));
        assertTrue(target.book(10, 40));
        int[][][] ranges = target.ranges();

        assertArrayEquals(new int[][]{{10, 40}, {50, 60}}, ranges[0]);
        assertArrayEquals(new int[][]{{10, 20}}, ranges[1]);

        assertFalse(target.book(5, 15));

        assertTrue(target.book(5, 10));
        ranges = target.ranges();
        assertArrayEquals(new int[][]{{5, 40}, {50, 60}}, ranges[0]);
        assertArrayEquals(new int[][]{{10, 20}}, ranges[1]);

        assertTrue(target.book(25, 55));
        ranges = target.ranges();
        assertArrayEquals(new int[][]{{5, 60}}, ranges[0]);
        assertArrayEquals(new int[][]{{10, 20}, {25, 40}, {50, 55}}, ranges[1]);
    }

    @Test
    public void testBook2() throws Exception {
        assertTrue(target.book(21, 22));
        assertTrue(target.book(86, 87));
        assertTrue(target.book(71, 72));
        assertTrue(target.book(76, 77));
        assertTrue(target.book(50, 51));
        assertTrue(target.book(92, 93));
        assertTrue(target.book(99, 100));
        assertTrue(target.book(5, 6));
        assertTrue(target.book(71, 72));
        assertTrue(target.book(42, 43));
        assertTrue(target.book(72, 73)); // second: 72->72
        assertTrue(target.book(22, 23));
        assertTrue(target.book(51, 52));
        assertTrue(target.book(15, 16));
        assertTrue(target.book(70, 71));
        assertTrue(target.book(64, 65));
        assertTrue(target.book(57, 58));
        assertTrue(target.book(47, 48));
        assertTrue(target.book(4, 5));
        assertTrue(target.book(14, 15));
        assertTrue(target.book(2, 3));
        assertTrue(target.book(28, 29));
        assertTrue(target.book(35, 36));
        assertTrue(target.book(86, 87));
        assertTrue(target.book(72, 73));
    }
}
