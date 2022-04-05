package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _252_MeetingRoomsTest {

    _252_MeetingRooms target = null;

    @Before
    public void before() throws Exception {
        target = new _252_MeetingRooms();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAttendAll1() throws Exception {
        int[][] meeting = {{0, 30}, {5, 10}, {15, 20}};
        boolean ans = target.attendAll(meeting);
        assertFalse(ans);
    }

    @Test
    public void testAttendAll2() throws Exception {
        int[][] meeting = {{7, 10}, {2, 4}};
        boolean ans = target.attendAll(meeting);
        assertTrue(ans);
    }

    @Test
    public void testAttendAll3() throws Exception {
        int[][] meeting = {{7, 10}, {2, 7}};
        boolean ans = target.attendAll(meeting);
        assertTrue(ans);
    }

    @Test
    public void testAttendAll4() throws Exception {
        int[][] meeting = {{7, 10}, {2, 7}, {10, 15}};
        boolean ans = target.attendAll(meeting);
        assertTrue(ans);
    }

    @Test
    public void testAttendAll5() throws Exception {
        int[][] meeting = {{7, 10}, {2, 7}, {1, 3}};
        boolean ans = target.attendAll(meeting);
        assertFalse(ans);
    }
}
