package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _630_CourseScheduleIIITest {

    _630_CourseScheduleIII target = null;

    @Before
    public void before() throws Exception {
        target = new _630_CourseScheduleIII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testScheduleCourse1() throws Exception {
        int courses = target.scheduleCourse(new int[][]{
                {2000, 3200}, {1000, 1250}, {100, 200}, {200, 1300},
        });
        assertEquals(3, courses);
    }

    @Test
    public void testScheduleCourse2() throws Exception {
        int courses = target.scheduleCourse(new int[][]{
                {2, 5}, {2, 19}, {1, 8}, {1, 3},
        });
        assertEquals(4, courses);
    }

    @Test
    public void testScheduleCourse3() throws Exception {
        int courses = target.scheduleCourse(new int[][]{
                {1, 2}
        });
        assertEquals(1, courses);
    }

    @Test
    public void testScheduleCourse4() throws Exception {
        int courses = target.scheduleCourse(new int[][]{
                {3, 2}, {4, 3}
        });
        assertEquals(0, courses);
    }
}
