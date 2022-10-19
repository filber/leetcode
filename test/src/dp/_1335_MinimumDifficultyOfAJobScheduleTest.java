package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1335_MinimumDifficultyOfAJobScheduleTest {

    _1335_MinimumDifficultyOfAJobSchedule target = null;

    @Before
    public void before() throws Exception {
        target = new _1335_MinimumDifficultyOfAJobSchedule();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinDifficulty1() throws Exception {
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        int d = 2;
        int difficulty = target.minDifficulty(jobDifficulty, d);
        // [6,5,4,3,2] + [1] = 6 + 1 = 7
        assertEquals(7, difficulty);
    }

    @Test
    public void testMinDifficulty2() throws Exception {
        int[] jobDifficulty = {9, 9, 9};
        int d = 4;
        int difficulty = target.minDifficulty(jobDifficulty, d);
        assertEquals(-1, difficulty);
    }

    @Test
    public void testMinDifficulty3() throws Exception {
        int[] jobDifficulty = {1, 1, 1};
        int d = 3;
        int difficulty = target.minDifficulty(jobDifficulty, d);
        assertEquals(3, difficulty);
    }

    @Test
    public void testMinDifficulty4() throws Exception {
        int[] jobDifficulty = {1, 2, 1};
        int d = 3;
        int difficulty = target.minDifficulty(jobDifficulty, d);
        assertEquals(4, difficulty);
    }
}
