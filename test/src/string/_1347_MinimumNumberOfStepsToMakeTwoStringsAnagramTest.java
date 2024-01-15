package string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1347_MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

    _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram target;

    @Before
    public void setUp() {
        target = new _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram();
    }

    @Test
    public void testMinSteps1() {
        String s = "bab";
        String t = "aba";
        int steps = target.minSteps(s, t);
        assertEquals(1, steps);
    }

    @Test
    public void testMinSteps2() {
        String s = "leetcode";
        String t = "practice";
        int steps = target.minSteps(s, t);
        assertEquals(5, steps);
    }

    @Test
    public void testMinSteps3() {
        String s = "anagram";
        String t = "mangaar";
        int steps = target.minSteps(s, t);
        assertEquals(0, steps);
    }
}