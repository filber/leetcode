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
        target = new STCalendar();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBook1() throws Exception {
        assertTrue(target.book(10, 20));
        assertTrue(target.book(50, 60));
        assertTrue(target.book(10, 40));
        assertFalse(target.book(5, 15));
        assertTrue(target.book(5, 10));
        assertTrue(target.book(25, 55));
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

    @Test
    public void testBook3() throws Exception {
        assertTrue(target.book(24, 40));
        assertTrue(target.book(43, 50));
        assertTrue(target.book(27, 43));
        assertTrue(target.book(5, 21));
        assertFalse(target.book(30, 40));
        assertFalse(target.book(14, 29));
        assertTrue(target.book(3, 19));
        assertFalse(target.book(3, 14));
        assertFalse(target.book(25, 39));
        assertFalse(target.book(6, 19));
    }
}
