package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._729_MyCalendarI.*;

import static org.junit.Assert.*;

public class _729_MyCalendarITest {

    MyCalendar target = null;

    @Before
    public void before() throws Exception {
        target = new MyCalendar();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBook1() throws Exception {
        assertTrue(target.book(10, 20));
        assertFalse(target.book(15, 25));
        assertTrue(target.book(20, 30));
    }

    @Test
    public void testBook2() throws Exception {
        assertTrue(target.book(10, 20));
        assertTrue(target.book(1, 10));
    }
}
