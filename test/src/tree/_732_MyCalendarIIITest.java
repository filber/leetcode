package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._732_MyCalendarIII.MyCalendarThree;

import static org.junit.Assert.*;

public class _732_MyCalendarIIITest {

    MyCalendarThree target = null;

    @Before
    public void before() throws Exception {
        target = new MyCalendarThree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBook1() throws Exception {
        assertEquals(1, target.book(10, 20));
        assertEquals(1, target.book(50, 60));
        assertEquals(2, target.book(10, 40));
        assertEquals(3, target.book(5, 15));
        assertEquals(3, target.book(5, 10));
        assertEquals(3, target.book(25, 55));
    }

    @Test
    public void testBook2() throws Exception {
        assertEquals(1, target.book(24, 40));
        assertEquals(1, target.book(43, 50));
        assertEquals(2, target.book(27, 43));
        assertEquals(2, target.book(5, 21));
        assertEquals(3, target.book(30, 40));
        assertEquals(3, target.book(14, 29));
        assertEquals(3, target.book(3, 19));
        assertEquals(3, target.book(3, 14));
        assertEquals(4, target.book(25, 39));
        assertEquals(4, target.book(6, 19));
    }


}
