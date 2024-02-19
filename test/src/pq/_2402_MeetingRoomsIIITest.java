package pq;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2402_MeetingRoomsIIITest {

    _2402_MeetingRoomsIII target;

    @Before
    public void setUp() throws Exception {
        target = new _2402_MeetingRoomsIII();
    }

    @Test
    public void testMostBooked1() {
        int n = 2;
        int[][] meetings = {{0, 10}, {1, 5}, {2, 7}, {3, 4}};
        int room = target.mostBooked(n, meetings);
        assertEquals(0, room);
    }

    @Test
    public void testMostBooked2() {
        int n = 3;
        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int room = target.mostBooked(n, meetings);
        assertEquals(1, room);
    }
}