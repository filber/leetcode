package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class _5_LongestPalindromicSubstringTest {

    _5_LongestPalindromicSubstring target = null;

    @Before
    public void before() throws Exception {
        target = new _5_LongestPalindromicSubstring();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestPalindrome1() throws Exception {
        String palindrome = target.longestPalindrome("babad");
        Set<String> set = new HashSet<>(Arrays.asList("bab", "aba"));
        assertTrue(set.contains(palindrome));
    }

    @Test
    public void testLongestPalindrome2() throws Exception {
        String palindrome = target.longestPalindrome("cbbd");
        Set<String> set = new HashSet<>(Arrays.asList("bb"));
        assertTrue(set.contains(palindrome));
    }

    @Test
    public void testLongestPalindrome3() throws Exception {
        String palindrome = target.longestPalindrome("aaaaa");
        Set<String> set = new HashSet<>(Arrays.asList("aaaaa"));
        assertTrue(set.contains(palindrome));
    }
}
