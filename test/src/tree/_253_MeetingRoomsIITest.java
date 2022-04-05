package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _253_MeetingRoomsIITest {

    _253_MeetingRoomsII target = null;

    @Before
    public void before() throws Exception {
        target = new _253_MeetingRoomsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLeastRooms1() throws Exception {
        int[][] meeting = {{0, 30}, {5, 10}, {15, 20}};
        int rooms = target.leastRooms(meeting);
        assertEquals(2, rooms);
    }

    @Test
    public void testLeastRooms2() throws Exception {
        int[][] meeting = {{7, 10}, {2, 7}, {1, 3}};
        int rooms = target.leastRooms(meeting);
        assertEquals(2, rooms);
    }

    @Test
    public void testLeastRooms3() throws Exception {
        int[][] meeting = {{7, 10}, {2, 7}, {10, 15}};
        int rooms = target.leastRooms(meeting);
        assertEquals(1, rooms);
    }

    @Test
    public void testLeastRooms4() throws Exception {
        int[][] meeting = {{0, 30}, {5, 10}, {15, 20}};
        int rooms = target.leastRooms(meeting);
        assertEquals(2, rooms);
    }

    @Test
    public void testLeastRooms5() throws Exception {
        int[][] meeting = {{0, 30}, {5, 10}, {15, 20}, {7, 16}};
        int rooms = target.leastRooms(meeting);
        assertEquals(3, rooms);
    }
}
