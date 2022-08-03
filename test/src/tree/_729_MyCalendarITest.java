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
        target = new SMCalendar();
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

    @Test
    public void testBook3() throws Exception {
        assertTrue(target.book(47, 50)); // [47,50)
        assertTrue(target.book(33, 41)); // [33,41),[47,50)
        assertFalse(target.book(39, 45));
        assertFalse(target.book(33, 42));
        assertTrue(target.book(25, 32)); // [25,32),[33,41),[47,50)
        assertFalse(target.book(26, 35));
        assertTrue(target.book(19, 25)); // [19,25),[25,32),[33,41),[47,50)
        assertTrue(target.book(3, 8)); // [3,8),[19,25),[25,32),[33,41),[47,50)
        assertTrue(target.book(8, 13)); // [3,8),[8,13),[19,25),[25,32),[33,41),[47,50)
        assertFalse(target.book(18, 27));
    }
}
