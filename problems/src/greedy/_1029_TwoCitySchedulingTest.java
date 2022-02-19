package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1029_TwoCitySchedulingTest {

    _1029_TwoCityScheduling target = null;

    @Before
    public void before() throws Exception {
        target = new _1029_TwoCityScheduling();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testTwoCitySchedCost1() throws Exception {
        //    A: 10 + 30 = 40
        //    B: 50 + 20 = 70
        int cost = target.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
        assertEquals(110, cost);
    }

    @Test
    public void testTwoCitySchedCost2() throws Exception {
        //    A: 184 + 259 + 577
        //    B: 54 + 118 + 667
        int cost = target.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}});
        assertEquals(1859, cost);
    }

    @Test
    public void testTwoCitySchedCost3() throws Exception {
        //    A: 343 + 451 + 515 + 537
        //    B: 42 + 60 + 359 + 779
        int cost = target.twoCitySchedCost(new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}});
        assertEquals(3086, cost);
    }


} 
