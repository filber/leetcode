package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _3_LongestSubstringWithoutRepeatingCharactersTest {

    _3_LongestSubstringWithoutRepeatingCharacters target = null;

    @Before
    public void before() throws Exception {
        target = new _3_LongestSubstringWithoutRepeatingCharacters();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLengthOfLongestSubstring1() throws Exception {
        int len = target.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLongestSubstring2() throws Exception {
        int len = target.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, len);
    }

    @Test
    public void testLengthOfLongestSubstring3() throws Exception {
        int len = target.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLongestSubstring4() throws Exception {
        int len = target.lengthOfLongestSubstring("");
        assertEquals(0, len);
    }

    @Test
    public void testLengthOfLongestSubstring5() throws Exception {
        int len = target.lengthOfLongestSubstring("ab abc abcd ");
        assertEquals(5, len);
    }
}
