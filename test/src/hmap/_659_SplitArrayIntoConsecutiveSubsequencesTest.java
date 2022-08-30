package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _659_SplitArrayIntoConsecutiveSubsequencesTest {

    _659_SplitArrayIntoConsecutiveSubsequences target = null;

    @Before
    public void before() throws Exception {
        target = new _659_SplitArrayIntoConsecutiveSubsequences();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsPossible1() throws Exception {
        boolean possible = target.isPossible(new int[]{1, 2, 3, 3, 4, 5});
        // [1,2,3] [3,4,5]
        assertTrue(possible);
    }

    @Test
    public void testIsPossible2() throws Exception {
        boolean possible = target.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
        // [1,2,3,4,5] [3,4,5]
        assertTrue(possible);
    }

    @Test
    public void testIsPossible3() throws Exception {
        boolean possible = target.isPossible(new int[]{1, 2, 3, 4, 4, 5});
        assertFalse(possible);
    }
}
