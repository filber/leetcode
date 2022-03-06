package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2193_MinimumNumberOfMovesToMakePalindromeTest {

    _2193_MinimumNumberOfMovesToMakePalindrome target = null;

    @Before
    public void before() throws Exception {
        target = new _2193_MinimumNumberOfMovesToMakePalindrome();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinMovesToMakePalindrome1() throws Exception {
        int moves = target.minMovesToMakePalindrome("aabb");
        assertEquals(2, moves);
    }

    @Test
    public void testMinMovesToMakePalindrome2() throws Exception {
        int moves = target.minMovesToMakePalindrome("abba");
        assertEquals(0, moves);
    }

    @Test
    public void testMinMovesToMakePalindrome3() throws Exception {
        int moves = target.minMovesToMakePalindrome("letelt");
        assertEquals(2, moves);
    }

    @Test
    public void testMinMovesToMakePalindrome4() throws Exception {
        // bdmmadb
        int moves = target.minMovesToMakePalindrome("bdmmdba");
        assertEquals(3, moves);
    }

}
