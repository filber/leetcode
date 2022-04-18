package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _621_TaskSchedulerTest {

    _621_TaskScheduler target = null;

    @Before
    public void before() throws Exception {
        target = new _621_TaskScheduler();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLeastInterval1() throws Exception {
        int time = target.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertEquals(8, time);
    }

    @Test
    public void testLeastInterval2() throws Exception {
        int time = target.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0);
        assertEquals(6, time);
    }

    @Test
    public void testLeastInterval3() throws Exception {
        int time = target.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
        assertEquals(16, time);
    }

    @Test
    public void testLeastInterval4() throws Exception {
        int time = target.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 10);
        assertEquals(56, time);
    }
}
