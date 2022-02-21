package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _340_LongestSubstringWithAtMostKDistinctCharactersTest {

    _340_LongestSubstringWithAtMostKDistinctCharacters target = null;

    @Before
    public void before() throws Exception {
        target = new _340_LongestSubstringWithAtMostKDistinctCharacters();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLengthOfLongestSubstringKDistinct1() throws Exception {
        // 3 - ece
        int len = target.lengthOfLongestSubstringKDistinct("eceba", 2);
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLongestSubstringKDistinct2() throws Exception {
        // 2 - aa
        int len = target.lengthOfLongestSubstringKDistinct("aa", 2);
        assertEquals(2, len);
    }

    @Test
    public void testLengthOfLongestSubstringKDistinct3() throws Exception {
        // 5 - ecebe
        int len = target.lengthOfLongestSubstringKDistinct("ecebe", 3);
        assertEquals(5, len);
    }

    @Test
    public void testLengthOfLongestSubstringKDistinct4() throws Exception {
        // 3 - eee
        int len = target.lengthOfLongestSubstringKDistinct("beeea", 1);
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLongestSubstringKDistinct5() throws Exception {
        // 3 - abc
        int len = target.lengthOfLongestSubstringKDistinct("abc", 3);
        assertEquals(3, len);
    }
}
