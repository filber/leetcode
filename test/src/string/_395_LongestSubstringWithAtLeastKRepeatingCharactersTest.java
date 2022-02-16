package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _395_LongestSubstringWithAtLeastKRepeatingCharactersTest {

    _395_LongestSubstringWithAtLeastKRepeatingCharacters target = null;

    @Before
    public void before() throws Exception {
        target = new _395_LongestSubstringWithAtLeastKRepeatingCharacters();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestSubstring1() throws Exception {
        // aaa
        int len = target.longestSubstring("aaabb", 3);
        assertEquals(3, len);
    }

    @Test
    public void testLongestSubstring2() throws Exception {
        // ababb
        int len = target.longestSubstring("ababbc", 2);
        assertEquals(5, len);
    }

    @Test
    public void testLongestSubstring3() throws Exception {
        // aaaaabbbbb
        int len = target.longestSubstring("aaabbbccaaaaabbbbb", 3);
        assertEquals(10, len);
    }

    @Test
    public void testLongestSubstring4() throws Exception {
        int len = target.longestSubstring("ababacb", 3);
        assertEquals(0, len);
    }
}
