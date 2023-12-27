package greedy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1578_MinimumTimeToMakeRopeColorfulTest {

    _1578_MinimumTimeToMakeRopeColorful instance;

    @Before
    public void setUp() {
        instance = new _1578_MinimumTimeToMakeRopeColorful();
    }

    @Test
    public void testMinCost1() {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        int minCost = instance.minCost(colors, neededTime);
        assertEquals(minCost, 3);
    }

    @Test
    public void testMinCost2() {
        String colors = "abc";
        int[] neededTime = {1, 2, 3};
        int minCost = instance.minCost(colors, neededTime);
        assertEquals(minCost, 0);
    }

    @Test
    public void testMinCost3() {
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 1};
        int minCost = instance.minCost(colors, neededTime);
        assertEquals(minCost, 2);
    }

    @Test
    public void testMinCost4() {
        String colors = "bbbaaa";
        int[] neededTime = {4, 9, 3, 8, 8, 9};
        int minCost = instance.minCost(colors, neededTime);
        assertEquals(23, minCost); // 4 + 3 + 8 + 8 = 23
    }
}