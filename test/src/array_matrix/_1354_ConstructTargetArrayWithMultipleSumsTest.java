package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1354_ConstructTargetArrayWithMultipleSumsTest {

    _1354_ConstructTargetArrayWithMultipleSums target = null;

    @Before
    public void before() throws Exception {
        target = new _1354_ConstructTargetArrayWithMultipleSums();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsPossible1() throws Exception {
        int[] arr = {5, 2};
        boolean possible = target.isPossible(arr);
        assertTrue(possible);
    }

    @Test
    public void testIsPossible2() throws Exception {
        int[] arr = {9, 3, 5};
        boolean possible = target.isPossible(arr);
        assertTrue(possible);
    }

    @Test
    public void testIsPossible3() throws Exception {
        int[] arr = {1, 1, 1, 2};
        boolean possible = target.isPossible(arr);
        assertFalse(possible);
    }

    @Test
    public void testIsPossible4() throws Exception {
        int[] arr = {8, 5};
        boolean possible = target.isPossible(arr);
        assertTrue(possible);
    }

    @Test
    public void testIsPossible6() throws Exception {
        int[] arr = {1, (int) 1e9};
        boolean possible = target.isPossible(arr);
        assertTrue(possible);
    }

    @Test
    public void testIsPossible7() throws Exception {
        int[] arr = {1, 1, 10};
        boolean possible = target.isPossible(arr);
        assertFalse(possible);
    }
}
