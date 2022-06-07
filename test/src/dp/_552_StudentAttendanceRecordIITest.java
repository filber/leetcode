package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _552_StudentAttendanceRecordIITest {

    _552_StudentAttendanceRecordII target = null;

    @Before
    public void before() throws Exception {
        target = new _552_StudentAttendanceRecordII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCheckRecord1() throws Exception {
        int record = target.checkRecord(3);
        assertEquals(19, record);
    }

    @Test
    public void testCheckRecord2() throws Exception {
        int record = target.checkRecord(4);
        assertEquals(43, record);
    }

    @Test
    public void testCheckRecord3() throws Exception {
        int record = target.checkRecord(5);
        assertEquals(94, record);
    }

    @Test
    public void testCheckRecord4() throws Exception {
        int record = target.checkRecord(6);
        assertEquals(200, record);
    }

    @Test
    public void testCheckRecord5() throws Exception {
        int record = target.checkRecord(2);
        assertEquals(8, record);
    }
}
