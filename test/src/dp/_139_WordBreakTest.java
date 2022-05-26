package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _139_WordBreakTest {

    _139_WordBreak target = null;

    @Before
    public void before() throws Exception {
        target = new _139_WordBreak();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWordBreak1() throws Exception {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        boolean ans = target.wordBreak(s, wordDict);
        assertTrue(ans);
    }

    @Test
    public void testWordBreak2() throws Exception {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        boolean ans = target.wordBreak(s, wordDict);
        assertTrue(ans);
    }

    @Test
    public void testWordBreak3() throws Exception {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        boolean ans = target.wordBreak(s, wordDict);
        assertFalse(ans);
    }

    @Test
    public void testWordBreak4() throws Exception {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "an", "cat");
        boolean ans = target.wordBreak(s, wordDict);
        assertTrue(ans);
    }
}
