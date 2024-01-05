package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _70_ClimbingStairsTest {

    _70_ClimbingStairs target;

    @Before
    public void setUp() throws Exception {
        target = new _70_ClimbingStairs();
    }

    @Test
    public void testClimbStairs1() {
        int ways = target.climbStairs(2);
        // 1+1
        // 2
        assertEquals(2, ways);
    }

    @Test
    public void testClimbStairs2() {
        int ways = target.climbStairs(3);
        // 1+2
        // 1+1+1
        // 2+1
        assertEquals(3, ways);
    }

    @Test
    public void testClimbStairs3() {
        int ways = target.climbStairs(4);
        // 1+1+1+1
        // 1+2+1
        // 2+1+1
        // 1+1+2
        // 2+2
        assertEquals(5, ways);
    }
}