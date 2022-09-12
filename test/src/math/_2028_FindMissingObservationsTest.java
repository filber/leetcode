package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2028_FindMissingObservationsTest {

    _2028_FindMissingObservations target;

    @Before
    public void before() throws Exception {
        target = new _2028_FindMissingObservations();
    }

    @After
    public void after() throws Exception {
    }

    private void assertArray(int[] rolls, int mean, int n, int[] arr) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int obvSum = 0;
        for (int val : rolls) {
            obvSum += val;
        }
        int expectedSum = totalSum - obvSum;
        int actualSum = 0;
        for (int val : arr) {
            actualSum += val;
        }
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testMissingRolls1() throws Exception {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        int[] arr = target.missingRolls(rolls, mean, n);
        assertEquals(n, arr.length);
        assertArray(rolls, mean, n, arr);
    }

    @Test
    public void testMissingRolls2() throws Exception {
        int[] rolls = {1, 5, 6};
        int mean = 3;
        int n = 4;
        int[] arr = target.missingRolls(rolls, mean, n);
        assertEquals(n, arr.length);
        assertArray(rolls, mean, n, arr);
    }

    @Test
    public void testMissingRolls3() throws Exception {
        int[] rolls = {1, 2, 3, 4};
        int mean = 6;
        int n = 4;
        int[] arr = target.missingRolls(rolls, mean, n);
        assertEquals(0, arr.length);
    }
}
